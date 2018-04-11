import win32com.client

def Hello():
    import win32com.client
    w=win32com.client.Dispatch("imacros")
    w.iimInit("", 1)
    w.iimPlay("Demo\\FillForm")
if __name__=='__main__':
    Hello()