# Rhythm Game [Tune of Heart]
It is a rhythm game based on Java and it is implemented by utilizing all basic Java technology.
## Reference : https://m.blog.naver.com/PostList.naver?blogId=ndb796

## 1. System Configuration
![시스템 구성도](https://user-images.githubusercontent.com/53389350/121283320-da5dab00-c915-11eb-87bb-6f32b53db411.png)

### Note Animation
![노트 애니메이션 원리](https://user-images.githubusercontent.com/53389350/121283298-d2057000-c915-11eb-845c-506395810ed4.png)
I used threads to constantly and automatically change coordinate values of Notes. Because coordinate values change repeatedly, it looks as if the note is going down, and event processing determines that the event occurs in the correct coordinates.

## 2. Database
![데이터베이스](https://user-images.githubusercontent.com/53389350/121283263-c9149e80-c915-11eb-8e9b-4fe73ba04502.jpg)
The database basically has member information and CD key information. Through this, members' personal information, scores, and records will be managed, and Java will link them through certain Java classes. It implements basic community functions such as genuine registration, login, and membership.
## 3. Class Diagram
![클래스다이어그램1](https://user-images.githubusercontent.com/53389350/121283222-bac68280-c915-11eb-9896-0a00da68c503.jpg)
![클래스다이어그램2](https://user-images.githubusercontent.com/53389350/121283243-c2862700-c915-11eb-9797-d169ae607adb.jpg)

## 4. View
### 1) Login
![1로그인](https://user-images.githubusercontent.com/53389350/121283099-89e64d80-c915-11eb-9d0d-e72d2b0282ef.jpg)

### 2) Register
![3회원가입](https://user-images.githubusercontent.com/53389350/121283121-923e8880-c915-11eb-97fd-5fe5e6a82d0e.jpg)

I didn't care much about login&register GUI, so it looks mess lol

### 3) Main Frame 
![메인 배경화면](https://user-images.githubusercontent.com/53389350/121283146-9bc7f080-c915-11eb-9c4c-da0a20f91ce2.jpg)

On the main screen, there are start and end buttons, and when you click the start button, you will be moved to the song selection screen.
The background music will play automatically when you launch the program.

### 4) Music Selection
![곡 선택화면](https://user-images.githubusercontent.com/53389350/121283157-a1bdd180-c915-11eb-9e2d-59d0360e29d9.jpg)

On the song selection screen, the corresponding song is automatically played and the song can be switched by pressing the arrow button.

### 5) Game Play
![게임 플레이 화면1](https://user-images.githubusercontent.com/53389350/121283166-a6828580-c915-11eb-99a9-d918fb343dd2.jpg)
![게임 플레이 화면2](https://user-images.githubusercontent.com/53389350/121283183-ac786680-c915-11eb-84bd-6cb85539ad89.jpg)

On the play screen, when the button is pressed according to the timing, the note is judged through event processing.
All judgments are classified according to timing and each grade has different scores. Such as Great, Perfect, miss and so on.

### 6) Score
![게임 플레이 화면3](https://user-images.githubusercontent.com/53389350/121283201-b26e4780-c915-11eb-8c49-c67e31f66eb0.jpg)

At the end of the play, the rating is printed by calculating the percentage of the total score.

## 4. Function List
### 1) Database Connection
### 2) Event Handling
### 3) Note Animation(Threads)
### 4) Score Rating
### 5) Music auto play
### 6) Login & Register
