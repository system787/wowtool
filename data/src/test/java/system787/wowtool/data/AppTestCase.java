package system787.wowtool.data;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import system787.wowtool.data.net.oauth.OauthApiImpl;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class AppTestCase {

    @InjectMocks
    private OauthApiImpl mOauthApi;

    @Test
    public void getTokenTest() {
        try {
            String token = mOauthApi.getToken();

            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
