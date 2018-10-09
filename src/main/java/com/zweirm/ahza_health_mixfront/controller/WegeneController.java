package com.zweirm.ahza_health_mixfront.controller;

import com.alibaba.fastjson.JSON;
import com.zweirm.ahza_health_mixfront.domain.wegene.WegeneProfiles;
import com.zweirm.ahza_health_mixfront.domain.wegene.WegeneToken;
import com.zweirm.ahza_health_mixfront.domain.wegene.WegeneUser;
import com.zweirm.ahza_health_mixfront.domain.wegene.athletigen.WegeneAthletigen;
import com.zweirm.ahza_health_mixfront.domain.wegene.lactoseMetabolism.WegeneLactose;
import com.zweirm.ahza_health_mixfront.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WegeneController {
    @Autowired
    private HttpClientService httpClientService;

    @RequestMapping(value = "/goGeneShow", method = RequestMethod.GET)
    public String getToken(@RequestParam("code") String code, Model model) {
        System.out.println(code);
        String url = "https://api.wegene.com/token/";

        HttpMethod method = HttpMethod.POST;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", "DGJ4qSqsR9V9tVPF");
        params.add("client_secret", "QSWNngHFZkVuDQeueZa24KGyHPbKhte6");
        params.add("grant_type", "authorization_code");
        params.add("code", code);
        params.add("redirect_uri", "http://localhost:8080/goGeneResult/" + code);
        params.add("scope", "basic health athletigen");
        String tokenJSON = httpClientService.client(url,method,params);

        WegeneToken token = JSON.parseObject(tokenJSON, WegeneToken.class);
        model.addAttribute("token", token);
        return "forward:/goGeneUser";
    }

    @RequestMapping("/goGeneUser")
    public String getWegeneUser(Model model) {
        String url = "https://api.wegene.com/user/";

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        WegeneToken token = (WegeneToken) request.getAttribute("token");
        String tokenStr = token.getAccess_token();

        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        String userJSON =  httpClientService.clientWithAuth(url, method, params, tokenStr);
        System.out.println(userJSON);

        WegeneUser wegeneUser = JSON.parseObject(userJSON, WegeneUser.class);

        model.addAttribute("wegeneUser", wegeneUser);
        model.addAttribute("token", token);
        return "forward:/goGeneAthletigenAndMetabolism";
    }

    @RequestMapping("/goGeneAthletigenAndMetabolism")
    public String getWegeneMetabolism(Model model) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        WegeneToken token = (WegeneToken) request.getAttribute("token");
        String tokenStr = token.getAccess_token();

        WegeneUser wegeneUser = (WegeneUser) request.getAttribute("wegeneUser");
        WegeneProfiles wegeneProfiles = wegeneUser.getProfiles().get(0);
        String wegeneProfilesId = wegeneProfiles.getId();

        // 获取乳糖代谢能力
        String lactoseUrl = "https://api.wegene.com/health/metabolism/" + wegeneProfilesId;
        HttpMethod method = HttpMethod.POST;
        MultiValueMap<String, String> lactoseParams = new LinkedMultiValueMap<>();
        lactoseParams.add("report_id", "5");
        String lactoseMetabolismJSON =  httpClientService.clientWithAuth(lactoseUrl, method, lactoseParams, tokenStr);
        System.out.println(lactoseMetabolismJSON);

        // 将乳糖代谢能力JSON转换为实体类
        WegeneLactose wegeneLactose = JSON.parseObject(lactoseMetabolismJSON, WegeneLactose.class);

        // 获取运动积极性
        String athletigenUrl = "https://api.wegene.com/athletigen/" + wegeneProfilesId;
        MultiValueMap<String, String> athletigenParams = new LinkedMultiValueMap<>();
        athletigenParams.add("report_id", "1490");
        String athletigenJSON =  httpClientService.clientWithAuth(athletigenUrl, method, athletigenParams, tokenStr);
        System.out.println(athletigenJSON);

        // 将运动积极性JSON转化为实体类
        WegeneAthletigen wegeneAthletigen = JSON.parseObject(athletigenJSON, WegeneAthletigen.class);

        // 将两个实体类传给页面
        model.addAttribute("wegeneLactose", wegeneLactose);
        model.addAttribute("wegeneAthletigen", wegeneAthletigen);

        return "forward:/goGeneResult";
    }
}
