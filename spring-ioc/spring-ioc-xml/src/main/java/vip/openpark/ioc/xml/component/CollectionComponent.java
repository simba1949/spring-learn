package vip.openpark.ioc.xml.component;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author anthony
 * @version 2023/11/14 19:00
 */
@Data
public class CollectionComponent {
    private String[] bookArray;
    private Set<Integer> numSet;
    private List<Dept> deptList;
    private Map<String, String> phoneMap;
}