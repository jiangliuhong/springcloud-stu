package top.jiangliuhong.scs.gen.ext;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import tk.mybatis.mapper.generator.MapperCommentGenerator;

/**
 * 扩展的注释生成器
 */
public class ScsCommentGenerator extends MapperCommentGenerator {

    private String author;

    private String currentDateStr;

    public ScsCommentGenerator() {
        super();
        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        StringBuilder sb = new StringBuilder();
        sb.append("/**");
        sb.append("\n");
        sb.append("* ");
        sb.append("\n");
        sb.append("* 数据表").append(introspectedTable.getFullyQualifiedTableNameAtRuntime()).append("映射bean，由Mybaits自动生成工具生成\n");
        sb.append("* @author " + author + "\n");
        sb.append("* @date " + currentDateStr + "\n");
        sb.append("*/");
        topLevelClass.addJavaDocLine(sb.toString());
        // super.addModelClassComment(topLevelClass, introspectedTable);
    }

}
