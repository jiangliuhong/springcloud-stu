package top.jiangliuhong.scs.gen.ext;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import tk.mybatis.mapper.generator.MapperCommentGenerator;

/**
 * 扩展的注释生成器
 */
public class ScsCommentGenerator extends MapperCommentGenerator {



    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        //https://blog.csdn.net/u012045045/article/details/83012681

        super.addModelClassComment(topLevelClass, introspectedTable);
    }

}
