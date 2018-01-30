package com.alibaba.boot.dubbo;

/**
 * dubbox-dubbo properties
 *
 * @author tan.bin
 * @date 2017/03/07
 * @since 1.0.0
 */
public class EudDubboxDubboProperties {
	/**
	 * communication protocol, default is dubbo default
	 * dubbo|rest|http|hessian|webservice
	 */
	private String protocol = "dubbo";
	/**
	 * 序列化方式kryo,
	 */
	private String serialization = "kryo";

	/**
	 * dubbo listen port, default 20800
	 */
	private int port = 20800;
	/**
	 * dubbo thread count, default 200
	 */
	private int threads = 200;

	private EudDubboxRestProperties dubboxRest = null;
	

	public EudDubboxRestProperties getDubboxRest() {
		return dubboxRest;
	}

	public void setDubboxRest(EudDubboxRestProperties dubboxRest) {
		this.dubboxRest = dubboxRest;
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

	public String getSerialization() {
		return serialization;
	}

	public void setSerialization(String serialization) {
		this.serialization = serialization;
	}

	@Override
	public String toString() {
		return "DubboProperties [appname=" + "" + ", registry=" + "" + ", protocol="
				+ this.protocol + ", port=" + this.port + ", threads=" + this.threads + ", version=" + ""
				+ ", group=" + "" + "]";
	}
}
