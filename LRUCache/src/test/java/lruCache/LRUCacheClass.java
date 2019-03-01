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
 *�@[ ] put���i�[�����L�[�l�ƃf�[�^���z��̍Ō�̗v�f����������ԏ��߂̗v�f(hoge[0]�̗v�f)�������A���ׂĂ̗v�f�ɓ����Ă���f�[�^��[n-1]�ԖڂɈڂ�
 *�@[ ] put���z��̍ł��Ō�̗v�f��null�ɂ���
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
		key[checkNullNum(key)]=keyString;
		data[checkNullNum(data)]=dataString;
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
	
	//checkNullNum�֐����O���N���X����e�X�g���邽�߂̊֐�1
	public int testCNNForKey() {
		return 	checkNullNum(key);
	}
	
	//checkNullNum�֐����O���N���X����e�X�g���邽�߂̊֐�2
	public int testCNNForData() {
		return checkNullNum(data);
	}
}
