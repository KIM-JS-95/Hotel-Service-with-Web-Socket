

# HOTEL (ADMIN PART)

```bash
호텔 운영에 필요한 ADMIN, CANCEL, CHECK IN/OUT 등의 기능 구현
```

## API Structure

### 1. IndexController
```bash
1. Home 화면
  @GetMapping("/")
  
2. 예약 요청 상태의 고객 리스트 조회 
  @GetMapping("/request/list")

3. 게스트 예약 요청 상세 정보 View
  @GetMapping("/request/list/{id}")

4. 게스트 예약 접수 (삭제 예정)
  @GetMapping("/request/accept/{id}")
```
### 2. Admin Controller
```bash
1. 게스트 및 해당 방 전체 리스트 조회
  @GetMapping("/stay")

3. CHECK-OUT
  @DeleteMapping("/stay/{RoomNum}")

4. GUEST INFO UPDATE 
  @PatchMapping("/stay/{id}")
```

### 2. Accept Controller
```bash
1. 예약 요청 상태의 고객 리스트 조회  (삭제예정)
  @GetMapping("/accept")

2. Empty 상태의 방을 조회하여 게스트의 접수 기능에 추가하여 예약 접수(AcceptController 수정할것)
  @PostMapping("/accept")

3. Only Empty 상태의 Room 조회
  @GetMapping("/accept/empty")

4. 예약 접수 취소 
  @DeleteMapping("/accept/cancel/{id}") (js 데이터 경로 수정)
```