package com.nilzxq.object;

/**
 * @author zxq @date 2017年1月3日
 *
 */
public class Admin {

	 private String name;
	    private Integer age;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }

	    @Override
	    public String toString() {
	        return "Admin{" +
	                "name='" + name + '\'' +
	                ", age=" + age +
	                '}';
	    }
}
