/**
 * www.mopaas.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.mopaas.utils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

/**
 *                       
 * @Filename: DockerClientUtils.java
 *
 * @Description: 
 *
 * @Version: 1.0
 *
 * @Author: yshen
 *
 * @Email: yang.shen@anchora.me
 *
 *       
 * @History:<br>
 *<li>Author: yshen</li>
 *<li>Date: 2017年5月12日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class DockerClientUtils {
    
    public static DockerClient createDockerClient(String host){
         DefaultDockerClientConfig config = DefaultDockerClientConfig
                                             .createDefaultConfigBuilder()
                                             .withDockerHost("tcp://"+host+":2375")
                                             .build();
         DockerClient dockerClient = DockerClientBuilder.getInstance(config).build();
        return dockerClient;
    }
    
}
