package com.alibaba.boot.dubbo;

/**
 * dubbox-webservice properties
 *
 * @author tan.bin
 * @date 2017/03/07
 * @since 1.0.0
 */
public class EudDubboxRestProperties {
	/**
	 * communication protocol, default is dubbo default
	 * dubbo|rest|http|hessian|webservice
	 */
	private String protocol = "rest";

	/**
	 * rest发布服务路径的上下文 如：/mdm-api/getSystemId();
	 */
	private String contextpath;

	/**
	 * 服务提供者容器实现 tomcat,jetty
	 */
	private String server = "tomcat";

	// 配置最大的HTTP连接数
	private Integer accepts = 500;

	/**
	 * tomcat listen port, default 20800
	 */
	private int port = 8080;
	/**
	 * dubbo thread count, default 200
	 */
	private int threads = 200;

	private String extension;

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getThreads() {
		return this.threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public String getContextpath() {
		return contextpath;
	}

	public void setContextpath(String contextpath) {
		this.contextpath = contextpath;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Integer getAccepts() {
		return accepts;
	}

	public void setAccepts(Integer accepts) {
		this.accepts = accepts;
	}

	@Override
	public String toString() {
		return "DubboProperties [appname=" + "" + ", registry=" + "" + ", protocol=" + this.protocol + ", port="
				+ this.port + ", threads=" + this.threads + ", version=" + "" + ", group=" + "" + "]";
	}
}
