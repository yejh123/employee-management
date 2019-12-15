package com.yejh.controller;/**
 * @author yejh
 * @create 2019-11_24 21:21
 */

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yejh.dao.DepartmentDao;
import com.yejh.dao.EmployeeDao;
import com.yejh.entities.Department;
import com.yejh.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @description: TODO
 **/
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAddPage(Model model) {
        //Collection<Department> departments = departmentDao.getDepartments();
        //model.addAttribute("departments", departments);
        model.addAttribute("employee", new Employee());
        return "edit";
    }

    /**
     * 增加@Valid注解，验证失败会报错。
     * 严重: Servlet.service() for servlet springDispatcherServlet threw exception
     * java.lang.NoSuchMethodError: javax.el.ExpressionFactory.newInstance()Ljavax/el/ExpressionFactory;
     *
     * Spring MVC 是通过对处理方法签名的规约来保存校验结果的：
     * 前一个表单/命令对象的校验结果保存到随后的入参中，
     * 这个保存校验结果的入参必须是 BindingResult 或 Errors 类型，
     * 这两个类都位于 org.springframework.validation 包中
     *
     * 需校验的 Bean 对象和其绑定结果对象或错误对象是成对出现的，它们之间不允许声明其他的入参
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmployee(@Valid Employee employee, BindingResult bindingResult) {
        System.out.println("addEmployee: " + employee);
        boolean hasErrors = bindingResult.hasErrors();
        if (hasErrors) {
            System.out.println("校验错误");
            return "edit";
        }
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/quickAdd", method = RequestMethod.POST)
    public String quickAddEmployee(@RequestParam(value = "employee") Employee employee) {
        System.out.println("quickAddEmployee: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String getEmployees(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        System.out.println("getEmployees: " + employees);
        return "list";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable(value = "id") Integer id, Model model) {
        //查询数据库
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "edit";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public String updateEmployeeById(@ModelAttribute("employee") Employee employee) {
        System.out.println("updateEmployeeById: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        if (id != null) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee", employee);
        }
    }


    /**
     * 使用 @RequestBody / @ResponseBody 对处理方法进行标注
     * 使用 HttpEntity<T> / ResponseEntity<T> 作为处理方法的入参或返回值
     */
    @RequestMapping(value = "/ajaxTest", method = RequestMethod.POST)
    @ResponseBody
    public Collection<Employee> ajaxTest(@RequestBody String s) {
        System.out.println("接收的数据：" + s);
        Collection<Employee> employees = employeeDao.getAll();
        return employees;
    }


}
