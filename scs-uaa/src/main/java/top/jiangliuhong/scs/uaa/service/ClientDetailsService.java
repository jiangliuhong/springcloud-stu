package top.jiangliuhong.scs.uaa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.jiangliuhong.scs.uaa.mapper.ClientDetailsMapper;

/**
 * ClientDetailsService <br/>
 *
 * @author jiangliuhong
 * @date 2020/10/8 10:56 上午
 * @version 1.0.0
 */
@Service
public class ClientDetailsService {

    @Resource
    private ClientDetailsMapper clientDetailsMapper;

}
