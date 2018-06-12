package com.cn.nlg.web;

import com.cn.nlg.domain.Damage;
import com.cn.nlg.service.DamageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 62746326@qq.com
 * @date create by 2018/6/12 11:27
 */
@Controller
@RequestMapping(value = "/damage")
public class DamageController {

    @Resource
    private DamageService damageService;

    /**
     *    处理 "/damage" 的 GET 请求，用来获取用户列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getDamageList(ModelMap map) {
        map.addAttribute("damageList", damageService.findAll());
        return "damageList";
    }

    /**
     * 显示创建用户表单
     *
     * @param map 视图参数
     * @return 返回跳转路径
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createDamageForm(ModelMap map) {
        map.addAttribute("damage", new Damage());
        map.addAttribute("action", "create");

        return "damageForm";
    }

    /**
     *  创建用户
     *    处理 "/damage" 的 POST 请求，用来获取用户列表
     *    通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postDamage(ModelMap map,
                           @ModelAttribute @Valid Damage damage,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "create");
            return "damageForm";
        }

        damageService.insertByDamage(damage);

        return "redirect:/damage/";
    }


    /**
     * 显示需要更新用户表单
     *    处理 "/damage/{id}" 的 GET 请求，通过 URL 中的 id 值获取 damage 信息
     *    URL 中的 id ，通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getDamage(@PathVariable Long id, ModelMap map) {
        map.addAttribute("damage", damageService.findById(id));
        map.addAttribute("action", "update");

        return "damageForm";
    }

    /**
     * 处理 "/damage/{id}" 的 PUT 请求，用来更新 damage 信息
     *
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putDamage(ModelMap map,
                          @ModelAttribute @Valid Damage damage,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "update");
            return "damageForm";
        }

        damageService.update(damage);
        return "redirect:/damage/";
    }

    /**
     * 处理 "/damage/{id}" 的 GET 请求，用来删除 damage 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDamage(@PathVariable Long id) {

        damageService.delete(id);
        return "redirect:/damage/";
    }
}
