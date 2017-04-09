package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AWordGameTest {

    private AWordGame aWordGame;

    @Before
    public void setUp() throws Exception {
        this.aWordGame = new AWordGame();
    }

    @Test
    public void testTopCoderExamples() throws Exception {
        Assert.assertEquals("treacherous", this.aWordGame.outcome(new String[]{"pascal program programmer task tree", "treacherous treachery tread trace"}));
        Assert.assertEquals("programmer", this.aWordGame.outcome(new String[]{"pascal programmer task tree", "treacherous treachery tread trace"}));
        Assert.assertEquals("code", this.aWordGame.outcome(new String[]{"academic","base","board","cola","code","cute","hack"}));
        Assert.assertEquals("tfcpmbawxv", this.aWordGame.outcome(new String[]{"lxxatbwhoh tooj lgwlu xiub lgwdinr rjjmufijoom", "vfdx toskry xhttofxo rkgqmb xiyyvyo qwbcpjcz", "lgquy ruyyptjv vazlfwy ruyypguoofimw qwbaarpfkukk", "xinhekafyi laehdkt lxxyerjt torxi lxxatijcg rkys", "xpktuvhcxhbg xiyyddlmf vazlfkxp xhf qwbaivq", "tookxlfs xiyydvil lxxatbng qwgzkvt rjlmcuwdug", "tdjlbbsr lxtoivq lwevhyms vfdo tfci lwevhyxmmm", "xpun qexfaistucs xinhgfyv qexxjfg xvljvc", "qwgzgina ruyqzuxbyovm ladihus rjjmufie", "qwgzgif xhnqem lwevhner xpuedqzd lpmedevkt", "vzefddtid lpmeji tfcypcvkqa tdjlbbcrm rjltci", "xhttofxfb xvljve xliwbcyxwg tookxf xhnqnw lgqvnh", "qwbqiu tdjlbbcz laehdycq lgqul qwbcpr lwevhyxi", "xpktuvhyc tdly rntxz xpanwsck laehdycz", "qwgzkva ruyypguj ruyqvsz rntg xibyr qwc xhnss", "xltrqddu vzcsdu qwbaijk lwevhymb xinhgfyo qwgzgf", "xhnqnggu toskrtau rjlmcums toskwaks xiyydvgx", "xiut qwbaartdb qexo rjlquefm xinl rjjifftthu", "rkyb lpmvbfn tfcpmbo rjlmczay rpt xltennu", "lgwdirzi lpmtvbija xpanwscbh tfur xhnqngrnhci", "xltrqbwdbl xlbwe rkghbk qwgzkk tdjw tdjry xvlfztz", "qwbaarpuyyse toswj xhttozvtv qwgc lxy toskrtawp", "rkgqx lgwdings xinhgfx lxtjtipnoy tfcpmbawxv", "vazlfwlo lpmvbxcct tfcpo lgqvnq lgkxgg rjlmczrm", "xpke rnte vajnf tfuwqdp qom xinhgcmsbmi tookxlfu", "xibyd xpatx lwevhnbn ladihuxw xpuep lxxaq vui", "lgkwbgs xvv tfuariim vazb xhva xinjovn xltrqdnqwy", "rjlmil xinhgcmk vzyvo lgwdplzpcon xiyydvgge ladp", "tdjlbudh lxxb lxxyerjynyx qwf xliwgsno lxtjetr", "xhttoftrvcabo xiyyddlqf xinheijxf rkghbn tfcype", "vfk xvayc xvlfzti laey rjltgh lgkmp rql vltqmow", "vzcsm qwbaivjn lpmvbxcwj qexxjfh lxtoivjrd", "lxxydxb xltl toskway xuyf tdlu tfuwhkp lxxatbwp", "lgkxgt qexfaiku xpktgyllgg vaq xlbiv lpmtvbikk", "lpmtvbgfo xiyphm tfcpmbau ruyd xlbil rkykcbf", "xpktgiusyzg lwevhnesh tdjrfy xhnsqe vzcq lgkmk", "lgwdirzsec vzefddtdbx lxtoii rjlmczau torak", "lpmtvbgoavjeq lxtjtipmhy xltrqddg vltqmytw", "rlxnh laehr xhtfmxvjn vltqmycl lgkwe qwbaijhx", "rjlmczro rkiaj xpktgia lwevuwow ruyqvsln lxtjtihl", "tdssjxz xiyydvie qwbaartk torax xlbwa xinheiha", "xvsmy vzcsds ruyqzuykr toskwakl tdjrfg vflz lxta", "xhnqnggj lxtoivjw tfuwhr lxtjetdp qexxjtg", "rnm xiue xpj vazlfwlfdg xhttozqr rkykcbo", "qwbcpjcmv tfuardg qwgzginklo tdssjd tfuardti lxl", "rlxb xhttye lwevuwl lgwiw rkykcmhltv qwgbsrgo", "tfuwqdgbh ruyqzxw lwemx xiypf xltrqbwm", "lpmedevcfkt"}));
    }
}
