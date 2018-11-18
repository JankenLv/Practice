package com.lvjing.cms.dao;

import com.lvjing.cms.entity.Canvas;
import com.lvjing.cms.mapper.CanvasMapper;
import com.lvjing.cms.util.JDBCUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CanvasDao {

    private SqlSession sqlSession;
    private int result;
    private List<Canvas> canvasList;

    private SqlSession getSqlSession() {
        sqlSession = JDBCUtil.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    private void closeSqlSession() {
        if (sqlSession!=null) {
            sqlSession.close();
        }
        sqlSession = null;
    }

    private CanvasMapper getCanvasMapper() {
        return getSqlSession().getMapper(CanvasMapper.class);
    }


    /**
     * 查找油画
     * @param canvas 查找条件
     * @return 存储油画的list集合
     */
    public List<Canvas> findCanvas(Canvas canvas) {
        try {
            canvasList = getCanvasMapper().findCanvas(canvas);
        } finally {
            closeSqlSession();
        }
        return canvasList;
    }


    /**
     * 根据id获取油画图片
     * @param id 油画id
     * @return 油画图片
     */
    public Canvas getSmallImg(int id) {
        Canvas canvas;
        try (SqlSession session = JDBCUtil.getSqlSessionFactory().openSession()) {
            System.out.println("currentThreadName: "+Thread.currentThread().getName()+
            " currentThreadNum: " + Thread.currentThread().getId() + " currentThreadGroup: " +
            Thread.currentThread().getThreadGroup());
            canvas = session.getMapper(CanvasMapper.class).getSmallImg(id);
        }
        return canvas;
    }


    /**
     * 统计油画总数
     * @return 油画总数
     */
    public int countCanvas() {
        try {
            result = getCanvasMapper().countCanvas();
        } finally {
            closeSqlSession();
        }
        return result;
    }


    /**
     * 统计某一分类下的油画总数
     * @param categoryId 油画分类
     * @return 油画总数
     */
    public int countCanvasOfCategory(int categoryId) {
        try {
            result = getCanvasMapper().countCanvasOfCategory(categoryId);
        } finally {
            closeSqlSession();
        }
        return result;
    }



    /**
     * 查找油画
     * @param firstIndex 查询的起始索引位置
     * @param lastIndex  限制显示的记录数
     * @return 存储油画的list集合
     */
    public List<Canvas> pagingForCanvas(int firstIndex, int lastIndex) {
        try {
            canvasList = getCanvasMapper().pagingForCanvas(firstIndex,lastIndex);
        } finally {
            closeSqlSession();
        }
        return canvasList;
    }


    /**
     * 根据分类查找油画
     * @param firstIndex 查询的起始索引位置
     * @param lastIndex  限制显示的记录数
     * @return 存储油画的list集合
     */
    public List<Canvas> pagingForCanvasOfCategory(int categoryId, int firstIndex, int lastIndex) {
        try {
            canvasList = getCanvasMapper().pagingForCanvasOfCategory(categoryId,firstIndex,lastIndex);
        } finally {
            closeSqlSession();
        }
        return canvasList;
    }


    /**
     * 添加油画
     * @param canvas 封装油画信息的实体类
     * @return 封装新增油画id的实体类
     */
    public Canvas addCanvas(Canvas canvas) {
        try {
            result = getCanvasMapper().addCanvas(canvas);
            if (result == 1) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
        return canvas;
    }

    /**
     * 更新油画
     * @param canvas 封装油画信息的实体类
     * @return 封装更新油画id的实体类
     */
    public Canvas updateCanvas(Canvas canvas) {
        try {
            result = getCanvasMapper().updateCanvas(canvas);
            if (result == 1) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
        return canvas;
    }

    /**
     * 删除油画
     * @param id 油画id
     */
    public void deleteCanvas(int id) {
        try {
            int result = getCanvasMapper().deleteCanvas(id);
            if (result == 1) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
    }


}
