/**
 * www.mopaas.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.mopaas.clientTest;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.LogContainerCmd;
import com.github.dockerjava.api.command.StartContainerCmd;
import com.github.dockerjava.api.model.Image;
import com.mopaas.utils.DockerClientUtils;

/**
 *                       
 * @Filename: MyTest.java
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
public class MyTest {
    /**
     * 列出当前机器上的镜像及tag
     */
    @Test
    public void createClient(){
        DockerClient dockerClent = DockerClientUtils.createDockerClient("10.0.2.15");
    
        List<Image> images = dockerClent.listImagesCmd().exec();
        for (Image image : images) {
            for (String rep : image.getRepoTags()) {
                System.out.println("################" + rep);
            }
        }
     }
    /**
     * 创建容器
     */
    @Test
    public void cerateContainer(){
        DockerClient dockerClent = DockerClientUtils.createDockerClient("10.0.2.15");
        CreateContainerResponse containerResponse = dockerClent.createContainerCmd("ubuntu:trusty").exec();
        System.out.println(containerResponse.getId());
        System.out.println(containerResponse.getWarnings());
        StartContainerCmd startContainerCmd = dockerClent.startContainerCmd(containerResponse.getId());
        System.out.println(startContainerCmd);
        System.out.println(startContainerCmd.getContainerId());
    }
    
    /**
     * 获取容器日志
     */
    @Test
    public void getContainerLog(){
        DockerClient dockerClent = DockerClientUtils.createDockerClient("10.0.2.15");
        dockerClent.startContainerCmd("1913b2707f3b8d7ce5906143e93b906800c25e3361af8071f3c58c24ac9eaf1a");
        LogContainerCmd log = dockerClent.logContainerCmd("1913b2707f3b8d7ce5906143e93b906800c25e3361af8071f3c58c24ac9eaf1a").withTailAll();
        System.out.println(log);
    }
}
