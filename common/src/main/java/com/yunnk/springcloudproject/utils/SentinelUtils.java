package com.yunnk.springcloudproject.utils;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * sentinel工具类
 * @author huangyigang
 */
public class SentinelUtils {
    /**
     * 动态增加流控规则
     * 以此类推，可增加其他规则，可参考: <a href="https://www.imooc.com/article/289345">Alibaba Sentinel 规则参数总结</a>
     * @param resource 资源名
     */
    private static void addFlowQpsRule(String resource) {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule(resource);
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
