require 'brainfuck'

RSpec.describe Brainfuck, "#output byte" do
  context "simple output" do
    it "print tab char" do
      expect { Brainfuck.new.interpret "+++++++++." }.to output("\t").to_stdout
    end

    it "print nl char" do
      expect { Brainfuck.new.interpret "++++++++++." }.to output("\n").to_stdout
    end

    it "print nl char with minus op" do
      expect { Brainfuck.new.interpret "+++++++++++-." }.to output("\n").to_stdout
    end

    it "print ~ char reverse minus" do
      expect { Brainfuck.new.interpret "--." }.to output("~").to_stdout
    end

    it "print ~~ char without array" do
      expect { Brainfuck.new.interpret "--.." }.to output("~~").to_stdout
    end

    it "print ~~ char with array" do
      expect { Brainfuck.new.interpret "--.>--." }.to output("~~").to_stdout
    end

    it "print ~ char with forward & backward move" do
      expect { Brainfuck.new.interpret "--><." }.to output("~").to_stdout
    end

    it "print all chars with loooooop" do
      expect { Brainfuck.new.interpret ".+[.+]" }.to output((0..127).map(&:chr).join).to_stdout
    end

    it "print all chars with loooooop" do
      expect { Brainfuck.new.interpret "[.+]" }.to output((0..127).map(&:chr).join).to_stdout
    end



    it "print Hello World!" do
      expect { Brainfuck.new.interpret "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++." }.to output("Hello World!\n").to_stdout
    end




  end
end
