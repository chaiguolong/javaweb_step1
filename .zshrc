ZSH_DISABLE_COMPFIX=true
# proxy list
alias proxy='export all_proxy=socks5://127.0.0.1:1080'
alias unproxy='unset all_proxy'
alias ip="curl -i http://ip.cn"
#ssh树莓派,密码：chaiguolong
alias ssh_pi='ssh pi@192.168.31.148'
#用于终端代理
alias wg="proxychains4 w3m www.google.com"
alias wb="w3m www.baidu.com"
alias grep='grep -n --color=auto'
alias rm='rm -i'
alias cp='cp -i'
alias mv='mv -i'
alias la='ls -a'
alias py2='python'
alias py3='python3'
#alias vim='mvim -v'
#alias vimdiff='mvimdiff -v'
alias cl='clear'
alias ssh_fq='ssh -p 29275 root@138.128.201.132'
alias ssh_xm='ssh -p 22 root@192.168.31.1'
alias ssh_pd='ssh root@10.211.55.41'
#显示隐藏文件
alias xs='defaults write com.apple.Finder AppleShowAllFiles Yes && killall Finder'
#隐藏显示文件
alias yc='defaults write com.apple.Finder AppleShowAllFiles No && killall Finder'
#开启tomcat
alias tstart='cd /Users/mymac/Library/apache-tomcat-7.0.90/bin && ./startup.sh'
#关闭tomcat
alias tstop='cd /Users/mymac/Library/apache-tomcat-7.0.90/bin && ./shutdown.sh'
#监控日志
alias console='cd /Users/mymac/Library/apache-tomcat-7.0.90/logs && tail -f catalina.out'
alias showerror='cd /Users/mymac/Library/apache-tomcat-7.0.90/logs && tail -n 20  catalina.out'
alias cdp='cd /Users/mymac/Documents/JavaWeb01'
#启动MySQL服务
#sudo /usr/local/MySQL/support-files/mysql.server start
alias mstart='sudo /usr/local/MySQL/support-files/mysql.server start'
#停止MySQL服务
#sudo /usr/local/mysql/support-files/mysql.server stop
alias mstop='sudo /usr/local/mysql/support-files/mysql.server stop'
#重启MySQL服务
#sudo /usr/local/mysql/support-files/mysql.server restart
alias mrestart='sudo /usr/local/mysql/support-files/mysql.server restart'
#开启插件eclim插件
alias estart='cd /Applications/Eclipse.app/Contents/Eclipse/ && ./eclimd'

# If you come from bash you might have to change your $PATH.
# export PATH=$HOME/bin:/usr/local/bin:$PATH

# Path to your oh-my-zsh installation.
export ZSH="/Users/mymac/.oh-my-zsh"

# Set name of the theme to load. Optionally, if you set this to "random"
# it'll load a random theme each time that oh-my-zsh is loaded.
# See https://github.com/robbyrussell/oh-my-zsh/wiki/Themes
ZSH_THEME="robbyrussell"

# Set list of themes to load
# Setting this variable when ZSH_THEME=random
# cause zsh load theme from this variable instead of
# looking in ~/.oh-my-zsh/themes/
# An empty array have no effect
# ZSH_THEME_RANDOM_CANDIDATES=( "robbyrussell" "agnoster" )

# Uncomment the following line to use case-sensitive completion.
# CASE_SENSITIVE="true"

# Uncomment the following line to use hyphen-insensitive completion. Case
# sensitive completion must be off. _ and - will be interchangeable.
# HYPHEN_INSENSITIVE="true"

# Uncomment the following line to disable bi-weekly auto-update checks.
# DISABLE_AUTO_UPDATE="true"

# Uncomment the following line to change how often to auto-update (in days).
# export UPDATE_ZSH_DAYS=13

# Uncomment the following line to disable colors in ls.
# DISABLE_LS_COLORS="true"

# Uncomment the following line to disable auto-setting terminal title.
# DISABLE_AUTO_TITLE="true"

# Uncomment the following line to enable command auto-correction.
# ENABLE_CORRECTION="true"

# Uncomment the following line to display red dots whilst waiting for completion.
# COMPLETION_WAITING_DOTS="true"

# Uncomment the following line if you want to disable marking untracked files
# under VCS as dirty. This makes repository status check for large repositories
# much, much faster.
# DISABLE_UNTRACKED_FILES_DIRTY="true"

# Uncomment the following line if you want to change the command execution time
# stamp shown in the history command output.
# You can set one of the optional three formats:
# "mm/dd/yyyy"|"dd.mm.yyyy"|"yyyy-mm-dd"
# or set a custom format using the strftime function format specifications,
# see 'man strftime' for details.
# HIST_STAMPS="mm/dd/yyyy"

# Would you like to use another custom folder than $ZSH/custom?
# ZSH_CUSTOM=/path/to/new-custom-folder

# Which plugins would you like to load? (plugins can be found in ~/.oh-my-zsh/plugins/*)
# Custom plugins may be added to ~/.oh-my-zsh/custom/plugins/
# Example format: plugins=(rails git textmate ruby lighthouse)
# Add wisely, as too many plugins slow down shell startup.
plugins=(
  git autojump
)

[[ -s `brew --prefix`/etc/autojump.sh  ]] && . `brew --prefix`/etc/autojump.sh

source $ZSH/oh-my-zsh.sh

# User configuration
source ~/.bash_profile

# export MANPATH="/usr/local/man:$MANPATH"

# You may need to manually set your language environment
# export LANG=en_US.UTF-8

# Preferred editor for local and remote sessions
# if [[ -n $SSH_CONNECTION ]]; then
#   export EDITOR='vim'
# else
#   export EDITOR='mvim'
# fi

# Compilation flags
# export ARCHFLAGS="-arch x86_64"

# ssh
# export SSH_KEY_PATH="~/.ssh/rsa_id"

# Set personal aliases, overriding those provided by oh-my-zsh libs,
# plugins, and themes. Aliases can be placed here, though oh-my-zsh
# users are encouraged to define aliases within the ZSH_CUSTOM folder.
# For a full list of active aliases, run `alias`.
#
# Example aliases
# alias zshconfig="mate ~/.zshrc"
# alias ohmyzsh="mate ~/.oh-my-zsh"
# export MYSQL="/usr/local/mysql/bin/"
# export PATH="/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:$MYSQL"
export ALL_PROXY=socks5://127.0.0.1:1080
# export CLASSPATH=${CLASSPATH}:"/Users/mymac/.vim/bundle/JavaUnit.vim/bin/HeimaShop_001:/Users/mymac/.vim/bundle/JavaUnit.vim/lib/*:."
export CLASSPATH=${CLASSPATH}:"/Users/mymac/Documents/JavaWeb01/HeimaShop/build/classes:/Users/mymac/Documents/JavaWeb01/HeimaShop/WebContent/WEB-INF/lib/*:."

export CLASSPATH=${CLASSPATH}:"/Users/mymac/Documents/javaSE/day19/bin:/Users/mymac/Documents/javaSE/day19/lib/*:."

[ -f ~/.fzf.zsh ] && source ~/.fzf.zsh
