"""
def lps(s):
    if s is None or s=="":
        return 0
    if len(s)==1:
        return 1
    if s[0]==s[-1]:
        return 2+lps(s[1:-1])
    return max(lps(s[:-1]),lps(s[1:]))
print(lps("abb"))
"""