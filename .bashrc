alias grep='grep -n --color=auto'
alias rm='rm -i'
alias cp='cp -i'
alias mv='mv -i'
alias la='ls -a'
alias py2='python'
alias py3='python3'
#alias vim='mvim -v'
alias cl='clear'
alias ssh_fq='ssh -p 29275 root@138.128.201.132'
lias ssh_xm='ssh -p 22 root@192.168.31.1'
#显示隐藏文件
alias xs='defaults write com.apple.Finder AppleShowAllFiles Yes && killall Finder'
#隐藏显示文件
alias yc='defaults write com.apple.Finder AppleShowAllFiles No && killall Finder'
#开启MySQL服务,密码为mysql
alias mstart='mysql.server start'
#关闭MySQL服务,密码为mysql
alias mstop='mysql.server stop'
#重启MySQL服务
alias mrestart='mysql.server restart'
#ssh树莓派,密码：chaiguolong
alias ssh_pi='ssh pi@192.168.31.148'
#将所有java文件移动到src目录
alias mv2src='mv *.java src'
#编译java文件至bin目录
alias javacp='javac -cp ../../../../lib:../../../../bin -sourcepath ../../../../bin -Djava.ext.dirs=../../../../lib -d ../../../../bin *.java'
alias javap='java -cp ../../../../bin -Djava.ext.dirs=../../../../lib %:p:h:t.%:p:t:r'
#编译java文件至bin目录(src下无包)
alias javacn='javac -cp ../lib:../bin -sourcepath ../bin -Djava.ext.dirs=../lib -d ../bin'
alias javan='java -cp ../bin -Djava.ext.dirs=../lib' 
#将GBK转为UTF-8,新建src bin lib 并把java文件移入src内
alias initcode='sudo sh changeGBK2UTF8.sh `pwd`&& mkdir src bin lib && mv *.java src'


export CLASSPATH=.:/Users/mymac/.vim/bundle/JavaUnit.vim/bin/:/Users/mymac/.vim/bundle/JavaUnit.vim/lib/*

[ -f ~/.fzf.bash ] && source ~/.fzf.bash
