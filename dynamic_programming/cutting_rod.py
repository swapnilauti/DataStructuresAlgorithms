"""def fun(arr,size):
    if size==0 or len(arr)==0:
        return 0
    if size-arr[-1]>=0:
        c1 =fun(arr,size-arr[-1])+arr[-1]
    else:
        c1=0
    return max(c1 if c1!=0 else 0,fun(arr[:-1],size))
print(fun([1, 5, 8, 9, 10, 17, 17, 20],8))
"""