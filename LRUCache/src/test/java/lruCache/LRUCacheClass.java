//���̐��ɒB������g���Ă��Ȃ����ɗv�f���폜����Ă���Map�̂悤�ȓ��ꕨ����肽��
//���̂���LastRecentlyUsedCache���쐬����B
//�L���b�V���̍ő�T�C�Y�ɒB�������ɁA�ł��g���Ă��Ȃ��f�[�^���珇�ɏ������d�g�݂��~����

/*�N���X�̎��ׂ�����
 * 2�̔z������@�v�f���̓L���b�V���T�C�Y
 * 1�̓L�[�l�A��̓f�[�^
 * 
 * put�֐��Ńf�[�^�ƃL�[�l�̒ǉ�
 * -���ɓ����Ă���L�[�l�Ɠ���̃L�[�l���w�肳�ꂽ��f�[�^�͏㏑�������iMap�̎d�l����j
 * get�֐��ň����ɓ��ꂽ�L�[�l�ƈ�v����f�[�^���R���\�[���ɏ����o��
 * 
 * �����o�������ꂽ�Ƃ��A������i�[����z��ƃL�[�l���i�[����z��̗v�f�i���e�j���ł��Ō�̗v�f�Ɏ����Ă���
 * �f�[�^�̒ǉ�����Ƃ��A�ł��Ō�̗v�f�ɒǉ�����B
 * �f�[�^�̒ǉ����ėv�f�������ς��ɂȂ������i�L���b�V���ő�T�C�Y�ɒB�������j�ł��ŏ��̗v�f���폜���A�������J��グ��
 * -���̃N���X�Ɋi�[�����f�[�^�̍ő吔�́A��ɃL���b�V���T�C�Y-1�ɕۂ����
 */

/*=====================================
 * �������͍̂ł��ߋ��ɎQ�Ƃ����f�[�^�B�p�x�ł͂Ȃ�
 * ====================================
 */

/*TODO
 * [x] �v�f����5�̔z��2�����N���X�̎����@�^��string
 * 
 * [ ] put�֐��ŃL�[�l�ƃf�[�^��v�f�̓����Ă��Ȃ��z��̗v�f�Ɋi�[
 * - [x] 0�Ԗڂ̗v�f�Ɉ������i�[����
 * [ ] get�֐��Ŏw�肳�ꂽ�L�[�l�Ƌ��Ɋi�[���ꂽ�f�[�^���R���\�[����ɕ\��
 *  - [x] ������1��Ԃ�get�֐�
 *
 * [ ] �f�[�^�������Ă��Ȃ��v�f�̌��o�֐�������
 * - [x] ����1��Ԃ�
 * - [x] null�̈�v����1�Ԗڂ܂ł̗v�f�����o���A0or1��Ԃ�
 * - [ ] null�̈�v������n�Ԗڂ̗v�f�����o���A����n��Ԃ�
 * 
 * [ ] put���i�[�����L�[�l�ƃf�[�^���z��̍Ō�̗v�f����������ԏ��߂̗v�f(hoge[0]�̗v�f)�������A���ׂĂ̗v�f�ɓ����Ă���f�[�^��[n-1]�ԖڂɈڂ�
 * - [x] �����Ƃ��ēn���ꂽkey�l���A�����̂��̂ƈ�v����v�f������ꍇ�A���̔ԍ���Ԃ�
 * - [x] �w�肳�ꂽ�Ԃ̗v�f��null�ɂ��āA�ȍ~�̗v�f��[n-1]�Ɉڂ��֐�

 * [ ] get���Ăяo���ꂽ�v�f�̃f�[�^�͐擪��null���i�[���ꂽ�v�f�Ɉڂ��A���������v�f������̗v�f��[n-1]�Ɉڂ�
 * 
 * [ ] �z��̗v�f����n�ɕύX
 */

package lruCache;

public class LRUCacheClass {
	String key[] = new String[5];
	String data[] = new String[5];
	
	//�L�[�l�ƃf�[�^���i�[����֐�
	public void put(String keyString,String dataString) {
		/*1�A�L�[�l����v����v�f�����鎞����������Ă���ȊO���\�[�g����
		 * 2�A�ł��擪��null�̏ꏊ�ɃL�[�l�ƃf�[�^���i�[
		 * 3�A�v�f���ő吔�ۑ�����Ă��鎞�A�擪�������ċl�߁A�Ō��null�ɂ���
		 */
		
		//1�̏���
		if(checkSameNum(key,keyString)!=-1) {//�L�[�l�Ɉ�v����v�f������
			key = deleteAndSort(checkSameNum(key,keyString),key);
			data = deleteAndSort(checkSameNum(data,dataString),data);
		}
		
		//�ۑ����s�i2�̏����j
		key[checkNullNum(key)]=keyString;
		data[checkNullNum(data)]=dataString;
		
		//3�̏���
		if(key[key.length - 1]!=null) {
			key=deleteAndSort(0,key);
			data=deleteAndSort(0,data);
		}
	}
	
	//�@�w�肳�ꂽ�L�[�l�ɑΉ������f�[�^��Ԃ��֐�
	public String get(String keyString) {
		return "1";
	}
	
	//�C�ӂ̔z��ɂ������āA�擪���琔���ď��߂�null���i�[����Ă���ԍ���Ԃ��֐�
	private int checkNullNum(String array[]) {
		int nullNum=0;
		
		//�z��̑S�v�f�ɑ΂��ČJ��Ԃ�
		for(String s:array) {
			if(s==null) {
				break;
			}else {
				nullNum++;
			}
		}
		
		return nullNum;
	}
	
	//�����Ƃ��Ďw�肳�ꂽString�ɁA�z��̒��ň�v����v�f�����鎞�A���̗v�f�̔ԍ��𐮐��ŕԂ��B��v���Ȃ����A����-1��Ԃ��B
	private int checkSameNum(String array[],String s) {
		int sameNum=-1;
		for (int i = 0; i < array.length;i++) {
			if(array[i]==s) {
				sameNum=i;
			}
		}
		return sameNum;
	}
	
	//�w�肳�ꂽ�Ԃ̗v�f��null�ɂ��āA�ȍ~�̗v�f��[n-1]�Ɉڂ��֐�
	public String[] deleteAndSort(int delNum,String array[]) {
		for(int i = delNum ; i < array.length -1  ; i++) {//�d�l��z��̍Ō�̗v�f�͕K��null�Ȃ̂ŗv�f�̍ő吔-1�����J��Ԃ�
			array[i]=array[i+1];
		}
		
		//�Ō�ɔz��̍Ō�͕K��null�ɂȂ鏈��
		array[array.length - 1]=null;
		
		return array;
	}
	
	//checkNullNum�֐����O���N���X����e�X�g���邽�߂̊֐�1
	public int testCNNForKey() {
		return 	checkNullNum(key);
	}
	
	//checkNullNum�֐����O���N���X����e�X�g���邽�߂̊֐�2
	public int testCNNForData() {
		return checkNullNum(data);
	}
}
