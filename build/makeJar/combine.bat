@echo off
::ת����ǰ�̷�
%~d0
::�򿪵�ǰĿ¼
cd %~dp0
::��������JAR����·��
set MainJar=mmbillingane.jar
::������JAR����·��
set ExternalJar=mmbilling.2.2.0.jar
::������JAR������������
set packageName=com
set packageName2=mm
set packageName3=assets
echo =========== start combin ==============
::��ѹ��������
jar -xf %ExternalJar%
::�ϲ���JAR��
jar -uf %MainJar% %packageName% 
::������б�Ķ��������Խ��źϲ������磺
jar -uf %MainJar% %packageName2%
::jar -uf %MainJar% %packageName3%
echo =========== over ==============
echo �ٵ�һ�¾ͽ�����--СQ
pause