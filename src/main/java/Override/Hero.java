package Override;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/4/14 22:46
 **/
public class Hero {

     String name(){
        return "超级英雄";
    }

    public class SuperMan extends Hero{
        @Override
        protected String name() {
            return "超人";
        }
        public Hero hero(){
            return new Hero();
        }
    }

    public class SuperSuperMan extends SuperMan{
        @Override
        public String name() {
            return "超级超级英雄";
        }

        @Override
        public Hero hero() {
            return new SuperMan();
        }
    }

}
