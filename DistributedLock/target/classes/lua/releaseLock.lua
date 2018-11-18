-- 内置了一个 redis 对象，其中 call 方法是调用了 redis 相关的命令
-- 内置了 KEY ARGV 两个数组  用来演示传递参数
-- 第三方库
if redis.call('get',KEYS[1]) == ARGV[1] then
    return redis.call('del',KEYS[1])
else
    return 0
end