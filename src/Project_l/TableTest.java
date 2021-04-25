package Project_l;

import javax.swing.*;
import javax.swing.table.*;

public class TableTest extends JFrame {
    private JLabel title = new JLabel("水果列表");		//上部标题
    private JScrollPane pane = new JScrollPane();	//表格滚动面板
    private JTable table = new JTable();			//水果表格

    public TableTest() {
        init();//窗口初始化
        addComponent();//添加表格
        updateTable();//刷新表格数据
    }
    public static void main(String[] args) {
        new TableTest();
    }
    //窗口初始化
    public void init() {
        this.setTitle("水果管理系统！");
        this.setSize(600, 420);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    //添加表格
    public void addComponent() {
        this.setLayout(null);//设置绝对布局
        //添加标题
        title.setBounds(265, 20, 70, 25);
        this.add(title);
        //表格
        table.getTableHeader().setReorderingAllowed(false);//列不能移动
        table.getTableHeader().setResizingAllowed(false);//不可拉动表格
        table.setEnabled(false);//表格不可更改数据
        pane.setBounds(50, 50, 500, 200);
        pane.setViewportView(table);//滚动面板显示表格数据
        this.add(pane);
    }
    //刷新表格数据
    public void updateTable() {
        String[] title = {"水果编号","水果名称","水果单价（/元）","计价单位"};
        Object[][] rowData = {
                {1,"苹果",5.5,"kg"}
        };

        TableModel dataModel = new DefaultTableModel(rowData, title);
        table.setModel(dataModel);
    }
}


