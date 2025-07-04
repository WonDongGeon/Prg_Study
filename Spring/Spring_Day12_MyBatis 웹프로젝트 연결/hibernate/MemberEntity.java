package hibernate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.ToString;

@Entity //라이브러리 hibernate 라이브러리 필요
//추가라이브러리 : jakarta.xml.bind-api, jaxb-runtime
//hibernate를 파일을 지원하는 플러그인 설정 : help-maket place에서 설치
//db접속 및 하이버네이트 설정(sql문관련한 사항)을 위한 파일 작성(hibernate.cfg.xml)
@Data
@ToString
public class MemberEntity {
	private String id;
	private String password;
}
