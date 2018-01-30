package com.alibaba.boot.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.boot.dubbo.endpoint.DubboEndpoint;
import com.alibaba.boot.dubbo.endpoint.DubboOperationEndpoint;
import com.alibaba.boot.dubbo.health.DubboHealthIndicator;
import com.alibaba.boot.dubbo.metrics.DubboMetrics;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * Dubbo common configuration
 *
 * @author xionghui
 * @author tan.bin
 * @date   2017/03/07	
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration {
  @Autowired
  private DubboProperties properties;

  @Bean
  @ConditionalOnMissingBean
  public ApplicationConfig dubboApplicationConfig() {
    ApplicationConfig appConfig = new ApplicationConfig();
    appConfig.setName(this.properties.getAppname());
    return appConfig;
  }

  @Bean(name="dubbo")
  //@ConditionalOnMissingBean
  public ProtocolConfig dubboProtocolConfig() {
    ProtocolConfig protocolConfig = new ProtocolConfig();
    if(this.properties.getDubboxDubbo() !=null){
    	EudDubboxDubboProperties eudProperties = new EudDubboxDubboProperties();
    	eudProperties=this.properties.getDubboxDubbo();
        protocolConfig.setName(eudProperties.getProtocol());
        protocolConfig.setPort(eudProperties.getPort());
        protocolConfig.setThreads(eudProperties.getThreads());
		protocolConfig.setSerialization(eudProperties.getSerialization());    
		return protocolConfig;
    }
    return null;
  }
  
  @Bean(name="rest")
  //@ConditionalOnMissingBean
  public ProtocolConfig restProtocolConfig() {
    ProtocolConfig protocolConfig = new ProtocolConfig();
    if(this.properties.getDubboxRest()!=null){
    	EudDubboxRestProperties eudProperties =new EudDubboxRestProperties();
    	eudProperties=this.properties.getDubboxRest();
		protocolConfig.setName(eudProperties.getProtocol());
		protocolConfig.setPort(eudProperties.getPort());
		protocolConfig.setThreads(eudProperties.getThreads());
		
		protocolConfig.setServer(eudProperties.getServer());
		if(StringUtils.isNotEmpty(eudProperties.getContextpath())){
		    protocolConfig.setContextpath(eudProperties.getContextpath());
		}
		if(StringUtils.isNotEmpty(eudProperties.getExtension())){
			protocolConfig.setExtension(eudProperties.getExtension());
		}
		protocolConfig.setAccepts(eudProperties.getAccepts());
		return protocolConfig;
    }
    return null;
  }
  
  @Bean
  @ConditionalOnMissingBean
  public RegistryConfig dubboRegistryConfig() {
    RegistryConfig registryConfig = new RegistryConfig();
    registryConfig.setAddress(this.properties.getRegistry());
    return registryConfig;
  }

  @Bean
  public DubboHealthIndicator dubboHealthIndicator() {
    return new DubboHealthIndicator();
  }

  @Bean
  public DubboEndpoint dubboEndpoint() {
    return new DubboEndpoint();
  }

  @Bean
  public DubboMetrics dubboConsumerMetrics() {
    return new DubboMetrics();
  }


  @Bean
  public DubboOperationEndpoint dubboOperationEndpoint() {
    return new DubboOperationEndpoint();
  }

}
