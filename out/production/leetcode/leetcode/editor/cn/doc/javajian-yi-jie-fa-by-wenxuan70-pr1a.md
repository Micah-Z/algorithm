这道题分为两步走:
- 通过遍历`path`,获取每个目录名称,这里包括`.`和`..`
    根据测试用例可知,路径中可能有多个`/`
    ```java
    //当遇到非'/'时,就说明此时到达目录名称的第一个字母
    if (path.charAt(i) != '/') {
        int j = i;
        while (j < len && path.charAt(j) != '/') {
            j++;
        }
        names.add(path.substring(i, j));
        i = j;
    }
    ```
- 遍历获取到的目录名称,构造路径
    这里要分三种情况
    1. 此时目录名称为`..`,如果前面有目录,就返回上一级(即把刚才加入路径的目录删除)
        ```java
        //如果目录名称为"..",需要特殊判断
        if (names.get(i).equals("..")) {
            //如果此时路径还有目录,则返回上一级;否则,忽略它
            if (res.size() > 0)
                res.remove(res.size() - 1);
        }
        ```
    2. 此时目录名称为`.`,说明处于当前目录,直接忽略即可
    3. 此时目录名称不为`..`或`.`,则直接加入路径
        ```java
        //如果目录名称不为"."(即当前目录),则加入路径
        res.add(names.get(i));
        ```
```java
class Solution {
    public String simplifyPath(String path) {
        //如果路径为空,直接返回"/"
        if (path == null || path.length() == 0) {
            return "/";
        }
        int len = path.length();
        List<String> names = new ArrayList<>();
        //获取每个目录名称
        for (int i = 0; i < len; i++) {
            if (path.charAt(i) != '/') {
                int j = i;
                while (j < len && path.charAt(j) != '/') {
                    j++;
                }
                names.add(path.substring(i, j));
                i = j;
            }
        }
        List<String> res = new ArrayList<>();
        //构造路径
        for (int i = 0; i < names.size(); i++) {
            //如果目录名称为"..",需要特殊判断
            if (names.get(i).equals("..")) {
                //如果此时路径还有目录,则返回上一级;否则,忽略它
                if (res.size() > 0)
                    res.remove(res.size() - 1);
            } else if (!names.get(i).equals(".")) {
                //如果目录名称不为"."(即当前目录),则加入路径
                res.add(names.get(i));
            }
            //如果上述情况都没匹配到,则说明该目录名称为"."(即当前目录),直接忽略
        }
        return "/" + String.join("/", res);
    }
}
```