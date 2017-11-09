package com.example.eurekaclient;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.EurekaInstanceConfig;

@RestController
public class Controller {
	
    private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private EurekaInstanceConfig eurekaInstanceConfig;	

	@Value("${server.port}")
    private int serverPort = 0;
	
	@RequestMapping(value = "music" ,method = RequestMethod.GET)
    public String music() {
        logger.info("/music, host:" + eurekaInstanceConfig.getHostName(false) +":"+serverPort+ ", service_id:" + eurekaInstanceConfig.getInstanceId() );
		return genDomZ(serverPort);
	}
	
	public String genDomZ(int i) {
		if(i%2 == 0){
			return "咚";
		}else{
			return "吱";
		}
	}
	
	
}
