import logging
import logging.handlers
import time
import os
import datetime
import configparser
import sendFile as sf


# Get serial number
def getserial():

# Extract serial from cpuinfo file
    cpuserial = "0000000000000000"

    try:

        f = open('/proc/cpuinfo','r')
        for line in f:
            if line[0:6]=='Serial':
                cpuserial = line[10:26]
                cpuserial = 'a' + cpuserial;
        f.close()
        
    except:

        cpuserial = "ERROR000000000"

    return cpuserial

    serialNumber = getserial()

    return serialNumber



# 로그 기록
def initializeLog() :

    global fileHandler, fomatter, streamHandler, logger
    global serialNumber, logFileName, logPath

    serialNumber = getserial()

    # 로거 인스턴스를 만든다
    logger = logging.getLogger('mylogger')
    # 포매터를 만든다
    fomatter = logging.Formatter('[%(levelname)s|%(filename)s:%(lineno)s] %(asctime)s > %(message)s')

    # 스트림과 파일로 로그를 출력하는 핸들러를 각각 만든다.
    date = datetime.datetime.now().strftime("%Y_%m_%d")

    # 로그 파일명
    logFileName = ('%s_' %(serialNumber)) + ('%s_' %(date)) + 'raspBerryLog.log'

    #fileHandler = logging.FileHandler('%s' %(logFileName))
    logPath = '/home/pi/jack/%s' %(date)

    os.system('mkdir %s' %(logPath))

    log_file = '%s/%s' %(logPath, logFileName)
    print(log_file)

    if os.path.isfile(log_file):
        pass
    else:
        f = open(log_file, 'w')
        f.close()
send_log = open(log_file, 'rb')

    fileHandler = logging.FileHandler('%s' %(log_file))

    streamHandler = logging.StreamHandler()
    sf.send_Log(send_log)


def writeLog(log) :

    # 각 핸들러에 포매터를 지정한다.
    fileHandler.setFormatter(fomatter)
    streamHandler.setFormatter(fomatter)

    # 로거 인스턴스에 스트림 핸들러와 파일핸들러를 붙인다.
    logger.addHandler(fileHandler)
    logger.addHandler(streamHandler)

    # 로거 인스턴스로 로그를 찍는다.
    logger.setLevel(logging.DEBUG)
    logger.debug(log)
def initializeIni():

    #ini setting
    iniPath = '/home/pi/jack/work/ini'

    if os.path.isdir(iniPath):
        pass

    else:
        os.system('mkdir %s' %(iniPath))

    iniFile = '%s/setting.ini' %(iniPath)

    config = configparser.ConfigParser()
    config.read(iniFile)


    # ini파일이 있다면
    if(os.path.isfile(iniFile)) :

        writeLog('iniFile exist')
        dayCount = config.get('section1', 'daycount')
        dayCount = int(dayCount)+1

        cfgfile = open('%s' %(iniFile), 'w')
        config.set('section1', 'daycount', str(dayCount))


        #15day
        if (dayCount%15 == 0) :
            print('start 15')
          #  day_Get_Site(serialNumber)
          #  sf.send_Fifteen(serialNumber)
            config.set('section1', 'daycount', '0')


    # ini
    else :
        writeLog('make iniFile')

        cfgfile = open('%s' %(iniFile), 'w')
        config.add_section('section1')
        config.set('section1', 'daycount', '0')
    
    config.write(cfgfile)
    dayCount = config.get('section1', 'daycount')

    print('dayCount =%s'%(dayCount))

    cfgfile.close()

    reboot()


def reboot():

    # 23시 재부팅

    # log파일 Read
    writeLog('send log file')
    path = '%s/%s' %(logPath, logFileName)
    print('test')
    print(path)
    logFile = open(path, 'rb')
    sf.send_Log(logFile)


