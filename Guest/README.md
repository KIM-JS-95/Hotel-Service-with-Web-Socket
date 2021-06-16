# HOTEL (GUEST PART)

```bash
 CANCEL, Book Request, Inquery 기능 구현
```
---

## API Structure
### Guest Controller

| API | 의미 | 기본값 |
|---|:---:|---:|
| @PostMapping("/CheckIn") | 예약  | ResponseEntity<?> |
| @GetMapping("/CheckInInquire") | 예약 조회 | Guest |
| @DeleteMapping("/CheckIn/{id}") | 예약 취소  | String |

* Guest save Json
```
{
  "email" : "baugh248730@gmail.com",
  "name": "kim",
  "phonenum": "010-1234-5677",
  "people": "10",
  "password" : "1234",
  "start" : 20210401,
  "end" : 20210401
}
```
* Guest Inquire Json

```
{
  "email" : "baugh248730@gmail.com",
  "name": "kim"
}
```

---



