package com.alibaba.boot.dubbo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * dubbo properties
 *
 * @author xionghui
 * @author tan.bin
 * @date 2017/03/07
 * 扩展dubboxRest属性
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "spring.dubbo")
public class DubboProperties {
	/**
	 * dubbo application name
	 */
	private String appname;
	/**
	 * dubbo registry address
	 */
	private String registry;

	/**
	 * dubbo version, may override by
	 * {@link com.alibaba.dubbo.config.annotation.Service#version()}
	 */
	private String version = "";

	/**
	 * dubbo group, may override by
	 * {@link com.alibaba.dubbo.config.annotation.Service#group()}
	 */
	private String group = "";
	/**
	 * dubbox RestProperties 
	 */
	private EudDubboxRestProperties dubboxRest = null;
	
	/**
	 * dubbox DubboProperties
	 */
	private EudDubboxDubboProperties dubboxDubbo=null;
	
	private EudDubboxWebserviceProperties dubboxWebservice=null;
	/*private Map<String, EudDubboxRestProperties> dubboRest = new HashMap<String, EudDubboxRestProperties>();

	public Map<String, EudDubboxRestProperties> getDubboRest() {
		return dubboRest;
	}

	public void setDubboRest(Map<String, EudDubboxRestProperties> dubboRest) {
		this.dubboRest = dubboRest;	
	}*/


	public EudDubboxWebserviceProperties getDubboxWebservice() {
		return dubboxWebservice;
	}

	public void setDubboxWebservice(EudDubboxWebserviceProperties dubboxWebservice) {
		this.dubboxWebservice = dubboxWebservice;
	}

	public EudDubboxRestProperties getDubboxRest() {
		return dubboxRest;
	}

	public EudDubboxDubboProperties getDubboxDubbo() {
		return dubboxDubbo;
	}

	public void setDubboxDubbo(EudDubboxDubboProperties dubboxDubbo) {
		this.dubboxDubbo = dubboxDubbo;
	}

	public void setDubboxRest(EudDubboxRestProperties dubboxRest) {
		this.dubboxRest = dubboxRest;
	}
	
	public String getAppname() {
		return this.appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getRegistry() {
		return this.registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "DubboProperties [appname=" + this.appname + ", registry=" + this.registry + ", protocol="
				+ "" + ", port=" + "" + ", threads=" + "" + ", version=" + this.version
				+ ", group=" + this.group + "]";
	}
}
