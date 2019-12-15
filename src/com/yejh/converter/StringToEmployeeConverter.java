package com.yejh.converter;/**
 * @author yejh
 * @create 2019-11_25 17:33
 */

import com.yejh.entities.Department;
import com.yejh.entities.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 **/

@Component
public class StringToEmployeeConverter implements Converter<String, Employee> {

    @Override
    public Employee convert(String source) {
        if(source!=null){
            String[] strs = source.split("-");
            if(strs.length == 4){
                String lastName = strs[0];
                String email = strs[1];
                Integer gender = Integer.parseInt(strs[2]);
                Integer deptId = Integer.parseInt(strs[3]);
                Department dept = new Department();
                dept.setId(deptId);
                Employee employee = new Employee(null,lastName,email,gender,dept);
                System.out.println(source+"--converter--"+employee);
                return employee ;
            }
        }
        return null;
    }
}
