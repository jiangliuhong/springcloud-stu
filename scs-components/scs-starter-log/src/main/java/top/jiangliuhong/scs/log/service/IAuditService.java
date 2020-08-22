package top.jiangliuhong.scs.log.service;


import top.jiangliuhong.scs.log.model.Audit;

/**
 * 审计日志接口
 */
public interface IAuditService {
    /**
     * 保存审计日志
     * @param audit audit
     */
    void save(Audit audit);
}
