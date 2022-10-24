import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C;
	
	static boolean[] pipe;
	
	static boolean[][] visit;
	static char[][] map;
	
	//상,하,좌,우
	static int[] di = {-1,1,0,0}; 
	static int[] dj = {0,0,-1,1}; 
	
	static char findPipe(int i, int j) { //비어있는 곳에 맞는 파이프를 찾는 메서드
		pipe = new boolean[4]; //상,하,좌,우 중 어느 곳과 연결되어 있는지 체크 - 0:상, 1:하, 2:좌, 3:우
		for(int d=0;d<4;d++) { //비어있는 좌표와 인접한 네 방향 탐색
			int ni = i+di[d]; 
			int nj = j+dj[d];
			
			if(!isIn(ni,nj)) continue; //만약 범위가 아닐 경우 연결 여부를 체크하지 않음
			
			if(d==0) { //현재 체크하고 있는 방향이 위쪽인 경우
				if(map[ni][nj]=='1' || map[ni][nj]=='|'||map[ni][nj]=='4'||map[ni][nj]=='+')
					pipe[0] = true; //연결된 파이프가 있을 경우 체크
			}
			else if(d==1) { //현재 체크하고 있는 방향이 아래쪽인 경우
				if(map[ni][nj]=='2' || map[ni][nj]=='|'||map[ni][nj]=='3'||map[ni][nj]=='+')
					pipe[1] = true; //연결된 파이프가 있을 경우 체크
			}
			else if(d==2) { //현재 체크하고 있는 방향이 왼쪽인 경우
				if(map[ni][nj]=='-' || map[ni][nj]=='2'||map[ni][nj]=='1'||map[ni][nj]=='+')
					pipe[2] = true; //연결된 파이프가 있을 경우 체크
			}
			else if(d==3) { //현재 체크하고 있는 방향이 오른쪽인 경우
				if(map[ni][nj]=='3' || map[ni][nj]=='-'||map[ni][nj]=='4'||map[ni][nj]=='+')
					pipe[3] = true; //연결된 파이프가 있을 경우 체크
			}
		}
		
		if(pipe[0]&&pipe[1]&&pipe[2]&&pipe[3]) return '+'; // 네 방향이 모두 연결된 경우
		else if(pipe[0]&&pipe[1]) return '|'; //위쪽, 아래쪽이 연결된 경우
		else if(pipe[2]&&pipe[3]) return '-'; //왼쪽, 오른쪽이 연결된 경우
		else if(pipe[1]&&pipe[3]) return '1'; //오른쪽, 아래쪽이 연결된 경우
		else if(pipe[1]&&pipe[2]) return '4'; //왼쪽, 아래쪽이 연결된 경우
		else if(pipe[2]&&pipe[0]) return '3'; //위쪽, 왼쪽이 연결된 경우
		else if(pipe[0]&&pipe[3]) return '2'; //위쪽, 오른쪽이 연결된 경우
		
		return '.';
		
	}
	
	static boolean isIn(int r, int c) { //해당 좌표가 범위 내에 있는지 체크하는 메서드
		if(r<0 || r>=R || c<0 || c>=C) //만약 행이나 열이 인덱스를 벗어나는 경우
			return false; //false 리턴
		return true; //범위 내에 있는 경우 true 리턴
	}
	
	static void check(int i, int j, char c) { //경로를 체크할 메서드
		if(c=='+'||c=='|'||c=='-') { //가로,세로,또는 네 방향이 모두 연결된 경우
			if(c=='+'||c=='|') { //세로방향이 연결된 파이프의 경우
				if(isIn(i-1,j)) visit[i-1][j] = true; //위쪽도 경로이므로 체크
				if(isIn(i+1,j)) visit[i+1][j] = true; //아래쪽도 경로이므로 체크
			}
			if(c=='+'||c=='-') { //가로방향이 연결된 파이프의 경우
				if(isIn(i,j-1)) visit[i][j-1] = true; //왼쪽도 경로이므로 체크
				if(isIn(i,j+1)) visit[i][j+1] = true; //오른쪽도 경로이므로 체크
			}
		}
		else if(c=='1') { //1번 파이프의 경우
			if(isIn(i,j+1)) visit[i][j+1] = true; //아래쪽도 경로이므로 체크
			if(isIn(i+1,j)) visit[i+1][j] = true; //오른쪽도 경로이므로 체크
		}
		else if(c=='2') { //2번 파이프의 경우
			if(isIn(i,j+1)) visit[i][j+1] = true; //아래쪽도 경로이므로 체크
			if(isIn(i-1,j)) visit[i-1][j] = true; //위쪽도 경로이므로 체크
		}
		else if(c=='3') { //3번 파이프의 경우
			if(isIn(i,j-1)) visit[i][j-1] = true; //왼쪽도 경로이므로 체크
			if(isIn(i-1,j)) visit[i-1][j] = true; //위쪽도 경로이므로 체크
		}
		else if(c=='4') { //4번 파이프의 경우
			if(isIn(i,j-1)) visit[i][j-1] = true; //왼쪽도 경로이므로 체크
			if(isIn(i+1,j)) visit[i+1][j] = true; //오른쪽도 경로이므로 체크
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine()); //R과 C를 입력받기 위한 StringTokenizer
			R = Integer.parseInt(st.nextToken()); //map의 행 길이 R 변수에 저장
			C = Integer.parseInt(st.nextToken()); //map의 열 길이 C 변수에 저장
			
			map = new char[R][]; // map 배열 초기화
			visit = new boolean[R][C]; //경로를 체크할 visit 배열 초기화
			
			//입력 받으면서 집에서 유치원 가는 경로 찾기
			for(int r=0;r<R;r++) { 
				map[r] = br.readLine().toCharArray(); //한 줄 입력받아서 map에 저장
				for(int c=0;c<C;c++) { // 한 행에 대한 모든 열 조사
					if(map[r][c]!='.') { //만약 파이프가 있는 길이라면
						visit[r][c] = true; //해당 좌표는 경로이므로 체크
						if(map[r][c]!='M' || map[r][c]!='Z') //현재 좌표가 유치원이나 집이 아닌 파이프인 경우에만 주변탐색
							check(r,c,map[r][c]); //경로찾기 메서드 호출
					}
				}
			}
			
			int i=-1,j=-1; //지워진 부분의 좌표를 저장할 변수
			//표시된 경로인데 지워진 부분 찾기
			for(int r=0;r<R;r++) { //모든 행 검사
				for(int c=0;c<C;c++) { //모든 열 검사
					if(visit[r][c]==true && map[r][c]=='.') { //경로에 포함되는 좌표인데 길로 표시된 경우 = 지워진 부분
						i = r; //행번호 저장
						j = c; //열번호 저장
						break; //원하는 위치를 찾았으므로 탐색 종료
					}
				}
				if(i>0 && j>0) break; //원하는 위치를 찾았으므로 탐색 종료
			}
			
			char ans = findPipe(i,j); //해당 좌표에 있어야 할 파이프 찾기
			i++; //map 배열이 0번 인덱스부터 시작하므로 좌표 하나 키워주기
			j++; //map 배열이 0번 인덱스부터 시작하므로 좌표 하나 키워주기
			System.out.println(i+" "+j+" "+ans); //테스트케이스와 함께 행번호, 열번호, 파이프의 종류 출력
		}
}