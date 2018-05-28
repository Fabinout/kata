class Brainfuck

  BYTE_SIZE = 128

  def initialize
    @data_pointer = 0
    @instructions_pointer = 0
    @data = [0]
    @stack = []
  end

  def interpret(instructions)
    instructions_size = instructions.size
    while @instructions_pointer < instructions_size 
      char = instructions[@instructions_pointer]
      case char
      when '+' then @data[@data_pointer] += 1
      when '-' then @data[@data_pointer] -= 1
      when '>' then @data_pointer += 1; @data[@data_pointer] ||= 0
      when '<' then @data_pointer -= 1; @data[@data_pointer] ||= 0
      when '.' then print to_value().chr
      when '[' then 
	@stack.push @instructions_pointer 
      when ']' then
        rock = @stack.pop
        if to_value() != 0
          @instructions_pointer = rock - 1
        end 
      else # ignore 
      end
      @instructions_pointer += 1
    end
    @data[@data_pointer]
  end

  def to_value
    @data[@data_pointer] % BYTE_SIZE
  end

end
