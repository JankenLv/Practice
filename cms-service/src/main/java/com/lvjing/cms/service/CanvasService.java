package com.lvjing.cms.service;

import com.lvjing.cms.dao.CanvasDao;
import com.lvjing.cms.entity.Canvas;

import java.util.List;

public class CanvasService {

    private static CanvasService canvasService;
    private CanvasDao canvasDao = new CanvasDao();

    private CanvasService(){};

    public static CanvasService getInstance() {
        if (canvasService==null) {
            canvasService = new CanvasService();
        }
        return canvasService;
    }


    /**
     * 查找油画
     *
     * @param canvas 查找条件
     * @return 存储油画的list集合
     */
    public List<Canvas> findCanvas(Canvas canvas) {
        return canvasDao.findCanvas(canvas);
    }


    /**
     * 根据id获取油画图片
     *
     * @param id 油画id
     * @return 油画图片
     */
    public Canvas getSmallImg(int id) {
        return canvasDao.getSmallImg(id);
    }


    /**
     * 统计油画总数
     *
     * @return 油画总数
     */
    public int countCanvas() {
        return canvasDao.countCanvas();
    }


    /**
     * 统计某一分类下的油画总数
     * @param categoryId 油画分类
     * @return 油画总数
     */
    public int countCanvasOfCategory(int categoryId) {
        return canvasDao.countCanvasOfCategory(categoryId);
    }


    /**
     * 分页查找油画
     *
     * @param firstIndex 第一个索引位置
     * @param lastIndex  第二个索引位置
     * @return 存储油画的list集合
     */
    public List<Canvas> pagingForCanvas(int firstIndex, int lastIndex) {
        return canvasDao.pagingForCanvas(firstIndex,lastIndex);
    }


    /**
     * 根据分类查找油画
     *
     * @param firstIndex 查询的起始索引位置
     * @param lastIndex  限制显示的记录数
     * @return 存储油画的list集合
     */
    public List<Canvas> pagingForCanvasOfCategory(int categoryId, int firstIndex, int lastIndex) {
        return canvasDao.pagingForCanvasOfCategory(categoryId,firstIndex,lastIndex);
    }


    /**
     * 添加油画
     *
     * @param canvas 封装油画信息的实体类
     * @return 封装新增油画id的实体类
     */
    public Canvas addCanvas(Canvas canvas) {
        return canvasDao.addCanvas(canvas);
    }

    /**
     * 更新油画
     *
     * @param canvas 封装油画信息的实体类
     * @return 封装更新油画id的实体类
     */
    public Canvas updateCanvas(Canvas canvas) {
        return canvasDao.updateCanvas(canvas);
    }

    /**
     * 删除油画
     *
     * @param id 油画id
     */
    public void deleteCanvas(int id) {
        canvasDao.deleteCanvas(id);
    }

}
