package sample;

public class Computer
{
    int id_comp = 0;
    int price;
    String type_computer;
    String proc_name;
    String dvd_privod;
    int video_memory;
    int proc_memory;
    double proc_freq;
    int cores;
    String type_display;
    String resolution;

    public Computer(String type_computer, String proc_name, double proc_freq, int proc_memory, int video_memory, String dvd_privod, int cores, String type_display, String resolution, int price)
    {
        this.price = price;
        this.type_computer = type_computer;
        this.proc_name = proc_name;
        this.proc_freq = proc_freq;
        this.video_memory = video_memory;
        this.proc_memory = proc_memory;
        this.dvd_privod = dvd_privod;
        this.cores = cores;
        this.type_display = type_display;
        this.resolution = resolution;
    }

    public Computer()
    {
        this.id_comp = 0;
        this.type_computer = null;
        this.proc_name = null;
        this.proc_freq = 0.0D;
        this.video_memory = 0;
        this.proc_memory = 0;
        this.dvd_privod = null;
        this.cores = 0;
        this.type_display = null;
        this.resolution = null;
        this.price = 0;
    }

    public int getId_comp()
    {
        return this.id_comp;
    }

    public void setId_comp(int id_comp)
    {
        this.id_comp = id_comp;
    }

    public int getPrice()
    {
        return this.price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getType_computer()
    {
        return this.type_computer;
    }

    public void setType_computer(String type_computer)
    {
        this.type_computer = type_computer;
    }

    public String getProc_name()
    {
        return this.proc_name;
    }

    public void setProc_name(String proc_name)
    {
        this.proc_name = proc_name;
    }

    public String getDvd_privod()
    {
        return this.dvd_privod;
    }

    public void setDvd_privod(String dvd_privod)
    {
        this.dvd_privod = dvd_privod;
    }

    public int getVideo_memory()
    {
        return this.video_memory;
    }

    public void setVideo_memory(int video_memory)
    {
        this.video_memory = video_memory;
    }

    public int getProc_memory()
    {
        return this.proc_memory;
    }

    public void setProc_memory(int proc_memory)
    {
        this.proc_memory = proc_memory;
    }

    public double getProc_freq()
    {
        return this.proc_freq;
    }

    public void setProc_freq(double proc_freq)
    {
        this.proc_freq = proc_freq;
    }

    public int getCores()
    {
        return this.cores;
    }

    public void setCores(int cores)
    {
        this.cores = cores;
    }

    public String getType_display()
    {
        return this.type_display;
    }

    public void setType_display(String type_display)
    {
        this.type_display = type_display;
    }

    public String getResolution()
    {
        return this.resolution;
    }

    public void setResolution(String resolution)
    {
        this.resolution = resolution;
    }

    public String toString()
    {
        return "Computer{id_comp=" + this.id_comp + ", type_computer='" + this.type_computer + '\'' + ", processor_name='" + this.proc_name + '\'' + ", proccess_frequency=" + this.proc_freq + ", video_memory=" + this.video_memory + ", process_memory=" + this.proc_memory + ", dvd_privod='" + this.dvd_privod + '\'' + ", core_amount=" + this.cores + ", display_type='" + this.type_display + '\'' + ", resolution =" + this.resolution + ", price=" + this.price + '}';
    }
}
