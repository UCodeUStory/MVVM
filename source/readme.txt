1.������ AbsActivity,AbsModule,IOCProxy,ModuleFactory

�����뷨��ÿ��Activity����Ӧ�ô���һ��Module�����洦�����������ҵ���߼���Ȼ��ص���Activity��Activity�������ҳ����֣�

MVC��Activity ������������ֱ�ӻص���Activity��Activity���ָ�View����

MVP ���˼�룬Activity ʵ��һ��View�ӿڣ�View�ӿ�������ȡ�ͳ���View���ݣ���View�ӿڸ�ί�и�presenter��presenter ����Modelִ�����������ص����View�ӿڵĶ�Ӧ������

MVVM ���������أ�

����Ҳ��Ҫһ��model�������Module�����ǲ�ҪPresenter�������Ǿ���Ҫ��Activity ֱ�Ӵ���Module������������˼·Activity ��Ҫ�ڴ���moduleʱ������һ���ص����󣬲��ܶ���һ���ڲ��໹���ⲿ�࣬����������ص�����ķ�������Ҫ�ص�activity����ķ��������ܸ���UI����ֱ�Ӹ���Ҳ���ԣ���Ҫ��View������Final����ʽ����������ǿ��ǽ�Activity������Ϊһ���ص��������������ж�Ӧ�Ļص�����������ǰ���岻ͬ��View�ӿ�����Ϊʵ������ʽ�����Ǵ�����ң��ȿ�������һ�ַ�ʽ���������ṩͳһ�Ļص��ӿڣ��������ɹ�ʧ�ܣ��ֱ���code�룬��Object���ͷ���ֵ���������������ݣ�����Ϊ����Activity�ص���ͬ�����Իص���װ��������������AbsActivity��������AbsActivity
�����ڴ���һ��IOCProxy ������module����ͬʱ��module��������ɹ����ص�����������
��Ϊͳһ�˾���������˳�ȡ������ABSModule���棬ͬʱ����Ҫ�и�ע��ص�����ķ�����������setListener,�������ɹ�����ܻص��������ķ����������ע��Ļص�������˭���أ���IOCProxy��IOCproxy �ڻص���Activity��


//���������������Activity��ʼ��ʱ������һ��IOCProxy ,��һ��module������ʱ��ͬʱ������module.setListener �����IocProxy���ݹ�ȥ��Activity����module�������󣬻ص������IOCProxy,IOCProxy �ٻص������Activity��

//��ʵ����һ�����̣� ���������ABSActivity ʵ��һ����������һ��module������ʱ��ͬʱ��Ȼ��ֱ�Ӵ���һ��module����ʵ�ַ�������ó��󷽷�����ABSActivityʵ����ʵ�����������ʡȥ�˴�����󣬣���ʵ�������������������ǰ�����޸��ǿ��Դ��ڵģ�