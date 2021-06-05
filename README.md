# Rhythm-game [Tune of Heart]

## Reference : https://m.blog.naver.com/PostList.naver?blogId=ndb796

## 1. Function
1) Event handle
2) Connecting Database(Eclipse, MySQL)
3) 2D Graphics
4) GUI
5) Playing Music automatically(Choosing music and main frame)

## 2. System configuration map
![시스템 구성도](https://user-images.githubusercontent.com/53389350/120879874-81ce9b00-c601-11eb-9042-836fa3a7209e.png)

Although I drew system composition in 3D, it seems difficult to understand intuitively.

## 3. Class Diagram
![클래스다이어그램1](https://user-images.githubusercontent.com/53389350/120879945-002b3d00-c602-11eb-81d2-f420157f1ad4.jpg)
![클래스다이어그램2](https://user-images.githubusercontent.com/53389350/120879952-08837800-c602-11eb-99e8-416b31edae80.jpg)

## 4. Demonstration View
### 1) Login
![1로그인](https://user-images.githubusercontent.com/53389350/120879804-f2c18300-c600-11eb-9598-1ac1930e3544.jpg)

### 2) Login Fail
![2로그인 실패](https://user-images.githubusercontent.com/53389350/120879817-0cfb6100-c601-11eb-8381-ea07332bfb43.jpg)

### 3) Register
![3회원가입](https://user-images.githubusercontent.com/53389350/120879857-66fc2680-c601-11eb-93a5-bbeca2d9819f.jpg)

I didn't care much about Login and register GUI, but it looks mess lol

### 4) Database
![데이터베이스](https://user-images.githubusercontent.com/53389350/120879985-3c5e9d80-c602-11eb-9d10-10bd96ef95fc.jpg)

The database basically has member information and CD key information. Through this, members' personal information, scores, and records will be managed, and Java will link them through certain Java classes. It implements basic community functions such as genuine registration, login, and membership.

### 5) Main Frame
![메인 배경화면](https://user-images.githubusercontent.com/53389350/120879958-146f3a00-c602-11eb-9ffb-1d8eebb24d2a.jpg)

On the main screen, there are start and end buttons, and when you click the start button, you will be moved to the song selection screen.
The background music will play automatically when you launch the program.

### 6) Music Selection
![곡 선택화면](https://user-images.githubusercontent.com/53389350/120879964-20f39280-c602-11eb-8803-d936b5a1dd73.jpg)

On the song selection screen, the corresponding song is automatically played and the song can be switched by pressing the arrow button.

### 7) Play View
![게임 플레이 화면1](https://user-images.githubusercontent.com/53389350/120879970-29e46400-c602-11eb-85a0-6d65fc819fcb.jpg)
![게임 플레이 화면2](https://user-images.githubusercontent.com/53389350/120879978-3072db80-c602-11eb-9de1-d805b53f4510.jpg)

On the play screen, when the button is pressed according to the timing, the note is judged through event processing.
All judgments are classified according to timing and each grade has different scores. Such as Great, Perfect, miss and so on.

### 8) Score View
![게임 플레이 화면3](https://user-images.githubusercontent.com/53389350/120879982-3799e980-c602-11eb-8e30-21bdf3a4b495.jpg)

At the end of the play, the rating is printed by calculating the percentage of the total score.
