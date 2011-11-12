#!/usr/bin/ruby

#******************************************************************************* 
#* Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated. 
#* All rights reserved. This program and the accompanying materials 
#* are made available under the terms of the Eclipse Public License v1.0 
#* which accompanies this distribution, and is available at 
#* http://www.eclipse.org/legal/epl-v10.html 
#* 
#* File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/grammar/bnf2jj.rb,v $
#* Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
#* Created on: 10/23/2006
#* Revision: $Id: bnf2jj.rb 164 2007-07-31 14:11:09Z mroy $
#* 
#* Contributors: IBM Corporation - initial API and implementation 
#*******************************************************************************/

def is_nonterminal token
  token =~ /^\w*[a-z]\w*(\(\))?$/
end
def is_terminal token
  token =~ /^[A-Z_]+$/
end
def print_rule lhs, rhs, nt
  # ensure whitespace before certain 
  # characters
  rhs.gsub!(/([?*+\(\)])/) {|c| " " + c}
  # wrap terminals in angle brackets
  # add parens to nonterminals
  rhs = rhs.split(/\s+/).inject([]) { |arr, token| 
    if is_nonterminal token 
      arr << "#{token}()" 
    elsif is_terminal token 
      arr << "<#{token}>" 
    else
      if (token == '?' || token == '*' || token == '+') && is_nonterminal(arr[-1])
        arr[-1] = "(#{arr[-1]})"
      end
      arr << token 
    end
  }.join("\n")
  if nt
    puts <<EOF
void #{lhs}() :
{}
{
  #{rhs}
}
EOF
  else
    puts <<EOF
  TOKEN : { <#{lhs}: #{rhs}  > }
EOF
  end
end


if ARGV.length != 1 or not File.exist? ARGV[0]
  puts "Usage: #{$0} grammar.bnf"
  exit
end

nonterminals = true
last_line = {'nt' => nil, 'rhs' => nil}
File.open(ARGV[0]) { |f|
  f.each_line { |line| 
    next unless line =~ /\S/
    line.chomp!
    if line =~ /^\[\d+\]\s+(\w+)\s+::=\s+(.+)$/
      if last_line['nt']
        print_rule(last_line['nt'], last_line['rhs'], nonterminals)
      end
      last_line['nt'] = $1
      last_line['rhs'] = $2
    elsif line =~ /@terminals/
      nonterminals = false
    else
      last_line['rhs'] += " #{line}"
    end
  }
}
if last_line['nt']
  print_rule(last_line['nt'], last_line['rhs'], nonterminals)
end

