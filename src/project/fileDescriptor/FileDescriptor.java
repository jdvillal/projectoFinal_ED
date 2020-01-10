/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.fileDescriptor;

import java.io.File;
import project.linkedList.LinkedList;

/**
 *
 * @author daniel
 *
 **/

public class FileDescriptor implements Descriptable {
    private final double size;
    private final String fileName;
    private final String style;

    public FileDescriptor(File toDescript) {
        this.fileName = toDescript.getName();
        if(toDescript.isDirectory()){
            this.size = getDirSize(toDescript);
            this.style ="-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1;";
        }else{
            this.size = toDescript.length();
            this.style = this.getStyle(this.getExtention(this.fileName));
        }    
    }
    
    public String getExtention(String file){
        String ext = "";
        for(int i = file.length(); i > 0; i--){
            if(file.charAt(i-1)=='.'){
                break;
            }else{
                ext = String.valueOf(file.charAt(i-1)) + ext;
            }
        }
        if(ext!=null)return ext;
        else return "";
    }
    
    public String getStyle(String extencion){
        LinkedList<String> text = new LinkedList();
        text.add("txt");text.add("doc");text.add("docx");text.add("dic");text.add("dochtml");text.add("diz");text.add("exc");
        text.add("idx");text.add("log");text.add("pdf");text.add("rtf");text.add("scp");text.add("wri");text.add("wtx");
        LinkedList<String> word = new LinkedList();
        word.add("dot");word.add("dothtml");word.add("wbk");word.add("wiz");
        LinkedList<String> excel = new LinkedList();
        excel.add("csv");excel.add("dif");excel.add("dqy");excel.add("xla");excel.add("xlb");excel.add("xlc");excel.add("xld");excel.add("xlk");
        excel.add("xll");excel.add("xls");excel.add("xlshtml");excel.add("xlt");excel.add("xlthtml");excel.add("xlv");excel.add("xlw");
        LinkedList<String> powerpoint = new LinkedList();
        powerpoint.add("pot");powerpoint.add("ppt");powerpoint.add("pothtml");powerpoint.add("ppa");powerpoint.add("pptx");powerpoint.add("pps");powerpoint.add("ppthtml");
        LinkedList<String> audio = new LinkedList();
        audio.add("669");audio.add("aif");audio.add("aifc");audio.add("aiff");audio.add("amf");audio.add("asf");audio.add("au");audio.add("audiocd");audio.add("cda");audio.add("far");
        audio.add("it");audio.add("itz");audio.add("lwv");audio.add("mid");audio.add("midi");audio.add("miz");audio.add("mp1");audio.add("mp2");audio.add("mp3");audio.add("mtm");
        audio.add("ogg");audio.add("ogm");audio.add("otk");audio.add("ra");audio.add("rmi");audio.add("snd");audio.add("stm");audio.add("stz");audio.add("utl");audio.add("voc");
        audio.add("wav");audio.add("wax");audio.add("wm");audio.add("wma");audio.add("wmv");audio.add("xm");audio.add("xmz");
        LinkedList<String> video = new LinkedList();
        video.add("asf");video.add("avi");video.add("bik");video.add("dvi");video.add("dvix");video.add("dvd");video.add("ivf");video.add("m1v");video.add("mov");
        video.add("movie");video.add("mp2v");video.add("mp4");video.add("mpa");video.add("mpe");video.add("mpeg");video.add("mpg");video.add("mpv2");video.add("qt");
        video.add("qtl");video.add("rpm");video.add("smk");video.add("wm");video.add("wmv");video.add("wob");
        LinkedList<String> image = new LinkedList();
        image.add("ais");image.add("amp");image.add("bw");image.add("cdr");image.add("cdt");image.add("cgm");image.add("cmx");image.add("cpt");image.add("dcx");
        image.add("dib");image.add("emf");image.add("gbr");image.add("gif");image.add("ico");image.add("iff");image.add("ilbm");image.add("jfif");image.add("jif");
        image.add("jpe");image.add("jpeg");image.add("jpg");image.add("kdc");image.add("lbm");image.add("mac");image.add("pat");image.add("pcd");image.add("pct");
        image.add("pcx");image.add("pic");image.add("pict");image.add("png");image.add("pix");image.add("psd");image.add("qti");image.add("qtif");image.add("rgb");
        image.add("rgba");image.add("rif");image.add("rle");image.add("sgi");image.add("tga");image.add("tif");image.add("tiff");image.add("wmf");image.add("xcf");       
        LinkedList<String> system = new LinkedList();
        system.add("386");system.add("aca");system.add("acg");system.add("acs");system.add("acw");system.add("ani");system.add("bat");system.add("bfc");
        system.add("bkf");system.add("blg");system.add("cat");system.add("cer");system.add("cfg");system.add("chk");system.add("chm");system.add("clp");
        system.add("cmd");system.add("cnf");system.add("com");system.add("cpl");system.add("crl");system.add("crt");system.add("cur");system.add("dat");
        system.add("db");system.add("der");system.add("dll");system.add("drv");system.add("ds");system.add("dsn");system.add("dun");system.add("exe");
        system.add("fnd");system.add("fng");system.add("folder");system.add("fon");system.add("grp");system.add("hlp");system.add("ht");system.add("inf");system.add("ini");
        system.add("ins");system.add("isp");system.add("job");system.add("key");system.add("lnk");system.add("msc");system.add("msi");system.add("msp");system.add("msstyles");
        system.add("nfo");system.add("ocx");system.add("otf");system.add("p7c");system.add("pfm");system.add("pif");system.add("pko");system.add("pma");system.add("zap");
        system.add("pmc");system.add("pml");system.add("pmr");system.add("pmw");system.add("pnf");system.add("psw");system.add("qds");system.add("rdp");
        system.add("reg");system.add("scf");system.add("sct");system.add("shb");system.add("shs");system.add("sys");system.add("theme");system.add("tmp");system.add("ttc");
        system.add("ttf");system.add("udl");system.add("vxd");system.add("wab");system.add("wmdb");system.add("wme");system.add("wsc");system.add("esf");system.add("wsh");
        LinkedList<String> compressed = new LinkedList();
        compressed.add("ace");compressed.add("arj");compressed.add("bz");compressed.add("bz2");compressed.add("cab");compressed.add("gz");compressed.add("ha");
        compressed.add("lha");compressed.add("lzh");compressed.add("r00");compressed.add("r01");compressed.add("r02");compressed.add("r03");compressed.add("rar");
        compressed.add("tar");compressed.add("tbz");compressed.add("tbz2");compressed.add("tgz");compressed.add("uu");compressed.add("uue");compressed.add("xxe");
        compressed.add("zip");compressed.add("zoo");
        LinkedList<String> internet = new LinkedList();
        internet.add("asp");internet.add("css");internet.add("hta");internet.add("htm");internet.add("html");internet.add("htt");internet.add("js");internet.add("jse");
        internet.add("jsp");internet.add("");internet.add("");internet.add("");internet.add("");internet.add("");internet.add("");internet.add("");
        internet.add("eml");internet.add("mht");internet.add("mhtml");internet.add("php");internet.add("shtm");internet.add("url");internet.add("xml");internet.add("xsl");
        internet.add("mbx");internet.add("msg");internet.add("nws");internet.add("");internet.add("");internet.add("");internet.add("");internet.add("");
        LinkedList<String> other = new LinkedList();
        other.add("c");other.add("cpp");other.add("h");other.add("bin");other.add("class");other.add("java");other.add("max");other.add("spl");other.add("swf");other.add("vbs");
        other.add("py");other.add("cs");
        LinkedList<String> diskimage = new LinkedList();
        diskimage.add("iso");diskimage.add("mds");diskimage.add("img");diskimage.add("dmg");diskimage.add("dmgpart");diskimage.add("disk");diskimage.add("dvdr");diskimage.add("hdi");
        diskimage.add("hds");diskimage.add("hfs");diskimage.add("ibp");diskimage.add("isz");diskimage.add("ncd");diskimage.add("sdi");diskimage.add("x64");diskimage.add("xvd");
        extencion = extencion.toLowerCase();
        if(text.contains(extencion)){
            return "-fx-fill: lavender; -fx-stroke: darkviolet; -fx-stroke-width: 1;";
        }else if(word.contains(extencion)){
            return "-fx-fill: royalblue; -fx-stroke: powderblue; -fx-stroke-width: 1;";
        }else if(excel.contains(extencion)){
            return "-fx-fill: seagreen; -fx-stroke: palegreen; -fx-stroke-width: 1;";
        }else if(powerpoint.contains(extencion)){
            return "-fx-fill: tomato; -fx-stroke: red; -fx-stroke-width: 1;";
        }else if(audio.contains(extencion)){
            return "-fx-fill: slateblue; -fx-stroke: deepskyblue; -fx-stroke-width: 1;";
        }else if(video.contains(extencion)){
            return "-fx-fill: lightpink; -fx-stroke: deeppink; -fx-stroke-width: 1;";
        }else if(image.contains(extencion)){
            return "-fx-fill: mistyrose; -fx-stroke: palevioletred; -fx-stroke-width: 1;";
        }else if(system.contains(extencion)){
            return "-fx-fill: tan; -fx-stroke: chocolate; -fx-stroke-width: 1;";
        }else if(compressed.contains(extencion)){
            return "-fx-fill: sienna; -fx-stroke: tan; -fx-stroke-width: 1;";
        }else if(internet.contains(extencion)){
            return "-fx-fill: aquamarine; -fx-stroke: darkcyan; -fx-stroke-width: 1;";
        }else if(other.contains(extencion)){
            return "-fx-fill: darkkhaki; -fx-stroke: yellow; -fx-stroke-width: 1;";
        }else if(diskimage.contains(extencion)){
            return "-fx-fill: skyblue; -fx-stroke: navy; -fx-stroke-width: 1;";
        }else{
            return "-fx-fill: dimgray; -fx-stroke: gainsboro; -fx-stroke-width: 1;";
        }
    }
    

    @Override
    public double getSize() {
        return this.size;
    }

    @Override
    public String getDescription() {
        return this.fileName;
    }

    private long getDirSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        for (File fl : files) {
            if (fl.isFile()) {
                length = length + fl.length();
            } else {
                length = length + getDirSize(fl);
            }
        }
        return length;
    }

    @Override
    public String getStyle() {
        return this.style;
    }

}
