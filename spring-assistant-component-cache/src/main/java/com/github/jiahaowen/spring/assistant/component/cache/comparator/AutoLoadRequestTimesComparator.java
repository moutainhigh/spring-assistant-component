package com.github.jiahaowen.spring.assistant.component.cache.comparator;

import com.github.jiahaowen.spring.assistant.component.cache.dto.AutoLoadDTO;
import java.util.Comparator;

/**
 * 根据请求次数，倒序排序，请求次数越多，说明使用频率越高，造成并发的可能越大。
 * @author jiahaowen
 */
public class AutoLoadRequestTimesComparator implements Comparator<AutoLoadDTO> {

    @Override
    public int compare(AutoLoadDTO autoLoadTO1, AutoLoadDTO autoLoadTO2) {
        if(autoLoadTO1 == null && autoLoadTO2 != null) {
            return 1;
        } else if(autoLoadTO1 != null && autoLoadTO2 == null) {
            return -1;
        } else if(autoLoadTO1 == null && autoLoadTO2 == null) {
            return 0;
        }
        if(autoLoadTO1.getRequestTimes() > autoLoadTO2.getRequestTimes()) {
            return -1;
        } else if(autoLoadTO1.getRequestTimes() < autoLoadTO2.getRequestTimes()) {
            return 1;
        }
        return 0;
    }

}
