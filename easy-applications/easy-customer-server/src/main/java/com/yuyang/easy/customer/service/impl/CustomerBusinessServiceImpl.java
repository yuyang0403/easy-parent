package com.yuyang.easy.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuyang.easy.common.entity.common.PagedVO;
import com.yuyang.easy.common.entity.customer.condition.DemoSearchCondition;
import com.yuyang.easy.common.entity.customer.model.TestModel;
import com.yuyang.easy.customer.mapper.TestModelMapper;
import com.yuyang.easy.customer.service.CustomerBusinessService;
import com.yuyang.easy.customer.test.ProxyClass;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yuyang
 * @date 2020/5/11 9:57
 * @Description
 */
@Service
public class CustomerBusinessServiceImpl implements CustomerBusinessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerBusinessServiceImpl.class);
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    Redisson redisson;
    @Autowired
    ProxyClass proxyClass;

    @Autowired
    TestModelMapper testModelMapper;


    @Async
    @Override
    public void testRedission() {
        LOGGER.info("开始获取锁-----");
        RLock rLock = redisson.getLock("myLock");
        LOGGER.info("是否有锁？："+rLock.isLocked());
        try {
            if(rLock.tryLock(10000,TimeUnit.MILLISECONDS)) {
                LOGGER.info("枷锁成功");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                LOGGER.info("等待超时，加锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(rLock.isLocked()) {
                rLock.unlock();
                LOGGER.info("释放锁："+rLock.getName());
            }
        }
        LOGGER.info("执行完毕-------");
    }

    @Override
    public void test() {
        LOGGER.info("调用feign接口");
        proxyClass.proxyTest();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveTest(TestModel testModel) {
        return testModelMapper.insertSelective(testModel);
    }

    @Override
    public PagedVO<TestModel> demoPage(DemoSearchCondition condition) {
        PagedVO<TestModel> pagedVO=new PagedVO<>();
        PageHelper.startPage(condition.getPageNum(),condition.getPageSize());
        List<TestModel> listResult=testModelMapper.selectByPage();
        PageInfo<TestModel> pageInfo = new PageInfo<>(listResult);
        pagedVO.setData(pageInfo.getList());
        pagedVO.setPageNo(pageInfo.getPageNum());
        pagedVO.setTotalRows(pageInfo.getTotal());
        return pagedVO;
    }
}
