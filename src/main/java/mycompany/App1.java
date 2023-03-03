package mycompany;

import com.dooray.sideapp.app.DooraySideApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App1 implements DooraySideApp {
    @Override
    public Map<String, Object> execute(Map<String, Object> map) {
        // TODO: 아래 서비스 성격에 알맞게 수정합니다.

        Map<String, Object> result = new HashMap<>();

        result.put("version", 1);
        result.put("layout", "A");

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", "2");
        m1.put("title", "MyCompany 임직원 재택근무 시행 안내");
        m1.put("description", "오늘부터 바로 시행합니다. 퇴근 가능하다면 바로 퇴근해주세요. 그리고...");
        m1.put("url", "https://payco.com/?app1-2");

        List<Map<String, String>> lm1Meta = new ArrayList<>();
        {
            Map<String, String> m = new HashMap<>();
            m.put("label", "등록자aaaaaaaaaaaaaaaaaaaaaaaaaa");
            m.put("text", "인사담당");
            lm1Meta.add(m);
        }
        {
            Map<String, String> m = new HashMap<>();
            m.put("label", "등록일");
            m.put("text", "2020.03.02.");
            lm1Meta.add(m);
        }
        m1.put("metadata", lm1Meta);
        list.add(m1);

        Map<String, Object> m2 = new HashMap<>();
        m2.put("id", "1");
        m2.put("title", "코로나19 바이러스 핫라인 안내");
        m2.put("url", "https://payco.com/?app1-1");
        list.add(m2);
        result.put("contents", list);

        Map<String, Object> onEmpty = new HashMap<>();
        onEmpty.put("text", "새로운 공지 사항이 없습니다.");
        onEmpty.put("url", "https://payco.com/?empty");

        result.put("onEmpty", onEmpty);

        return result;
    }
}
