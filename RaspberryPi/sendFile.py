import setting as set
import datetime
import os
import requests
import time




# 파일 전송
#res = requests.post('http://192.168.0.56:8081/test',  data = obj, files = upload)res = requests.post('http://192.168.0.56:8081/test',  data = obj, files = upload)res = requests.post('http$
def send_Image(file, path, temper, humidity):

    res =''

    try :
        set.writeLog ("%s" %(file))
        set.writeLog ("Start file_Post_Site()")

        obj={"temperature":temper, "humidity":humidity}
        upload={"file":file}

        set.writeLog('temperature = %s' %(temper))
        set.writeLog('humidity = %s' %(humidity))
       
        res = requests.post('http://14.32.7.115:605/imgFile',  data = obj, files = upload)
        check = '%s' %(res)

        # 정상 전송될 때,
        if(check.find('200') != -1) :

            set.writeLog ("Complete")

            if(str(file).find('.log') != -1) :
                print('test')

            # 전송 후, 사진파일 삭제.
            set.writeLog('delete file = %s' %(path))
            os.system('rm -f %s' %(path))
        # 실패할 떄,
        else :

            set.writeLog('REQUEST \'200\'ERROR')

    except :
        set.writeLog('Msg = %s' %(res))
        set.writeLog ("Error file_Post")
        return



def send_Log(file):

    res=''

    try :
        set.writeLog ("Start send_Log() = %s" %(file))

        upload={"file":file}

        res = requests.post('http://192.168.0.16:8080/imgFile', files = upload)
        check = '%s' %(res)

        # 정상 전송될 때,
        if(check.find('200') != -1) :

            set.writeLog ("Complete")

        # 실패할 떄,
        else :
            set.writeLog('REQUEST \'200\'ERROR')

    except :
        set.writeLog('Msg = %s' %(res))
        set.writeLog ("Error send_Log")
        return



def send_Fifteen(serialNumber):

    try :
        res = requests.get('http://192.168.0.16:8080/fifteen', serialNumber)
        check = '%s' %(res)

        # 정상 전송될 때,
        if(check.find('200') != -1) :

            set.writeLog ("Complete day_Get_Site")

        # 실패할 떄,
        else :
            set.writeLog('REQUEST \'200\'ERROR')

    except :
        set.writeLog ("Error send_Log")
        return
        
