"ggvG=格式化代码"
"这是提交到git的.vimrc,现在主文件改动,看看硬连接有咩有改
nnoremap <leader>sv :source $MYVIMRC<cr>
nnoremap <leader>ev :vsplit $MYVIMRC<cr>
"运行java文件的自动设置路径
let s:isJava = fnamemodify(expand('%'),':p:e')
"如果是java,运行编译命令,如果不是复制该文件到同级目(因为设置了javaComplite_libs变量,在编译时调用了该变量,所以注释掉)
" if(s:isJava == 'java')
" 	autocmd BufReadPost *.java, let g:myTools_custom_tempdir=split(expand('%:p'),"src")[0]."bin"
" endif 
"movement映射,cp为修改括号内字符,dp为删除括号内字符
:onoremap p i(
"开启折叠
set foldmethod=indent
"启动vim时关闭折叠
set nofoldenable
" set foldmethod=manual
" set foldmethod=syntax

"禁止自动换行
"autocmd BufNewFile,BufRead *.html,*.jsp setlocal nowrap
:set fileencodings=utf-8,ucs-bom,gb18030,gbk,gb2312,cp936
:set termencoding=utf-8
:set encoding=utf-8
" let g:lightline = {'colorscheme': 'solarized'}
"支持鼠标操作
":set mouse=a
" 定义快捷键的前缀，即<Leader>
let mapleader=";"
" 开启文件类型侦测
filetype on
" 根据侦测到的不同类型加载对应的插件
filetype plugin on
" 开启实时搜索功能
set incsearch
"设置命令行的高度
"set cmdheight=1
"设置quickfix窗口显示的最大条目数
let g:ctrlp_max_height = 3
" 搜索时大小写不敏感
set ignorecase
" 去掉有关vi一致性模式，避免以前版本的一些bug和局限，解决backspace不能使用的问题
set nocompatible
 set backspace=indent,eol,start
" set backspace=1
" 共享剪贴板
 set clipboard+=unnamed
" 顶部底部保持3行距离
" set scrolloff=3
" vim 自身命令行模式智能补全
set wildmenu
"vim禁用自动备份
set nobackup
set nowritebackup
set noswapfile
" 显示光标当前位置
set ruler
" 开启行号显示
set number
"高亮显示当前行/列
set cursorline
set cursorcolumn
" 高亮显示搜索结果
set hlsearch
"总是显示状态栏
set laststatus=2
" 开启语法高亮功能
 syntax enable
" 允许用指定语法高亮配色方案替换默认方案,vim有点卡就改为off了,测试是不是这个选项导致vim卡顿
 syntax on
"设置使用该配色主题,在.vim/color目录下
" syntax enable
set background=dark
"set background=light
"colorscheme solarized
 colorscheme gruvbox
"设置 gvim 显示字体
set guifont=YaHei\ Consolas\ Hybrid\ 11.5
" 禁止折行
"set nowrap
" 自适应不同语言的智能缩进
filetype indent on
" 将制表符扩展为空格
"set expandtab
" 设置编辑时制表符占用空格数
set tabstop=4
" 设置格式化时制表符占用空格数
set shiftwidth=4
" 让 vim 把连续数量的空格视为一个制表符
set softtabstop=4
set gcr=a:block-blinkon0
" 禁显示滚动条
set guioptions-=l
set guioptions-=L
set guioptions-=r
set guioptions-=R
" 禁止显示菜单和工具条
set guioptions-=m
set guioptions-=T

"注释行换行不再有注释符号,第一种在js中没用,暂时用第二种
"au FileType java,jsp,js,c setlocal comments-=:// comments+=f://
autocmd FileType * setlocal formatoptions-=c formatoptions-=r formatoptions-=o

"粘贴模式
":set paste

" vundle 环境设置
filetype off
set rtp+=~/.vim/bundle/Vundle.vim
" vundle 管理的插件列表必须位于 vundle#begin() 和 vundle#end() 之间
call vundle#begin()
Bundle 'tpope/vim-surround'
" Bundle 'thinca/vim-quickrun'
" Bundle 'Shougo/unite.vim'
"自动测试java文件,先试试
" Bundle 'rodolfoliviero/java-autotest'
"重命名文件
Bundle 'danro/rename.vim'
"单元测试
Bundle 'wsdjeg/JavaUnit.vim'
"写流程图
" Bundle 'vim-scripts/DrawIt'
"Oracle语法缩进
"Bundle 'chrisbra/vim-sqloracle-syntax'
"sql关键字自动大写
" Bundle 'alcesleo/vim-uppercase-sql'
"sql实用程序
" Bundle 'vim-scripts/SQLUtilities'
"sql语句补全
" Bundle 'vim-scripts/SQLComplete.vim'
"轻松重用终端
" Bundle 'kassio/neoterm'
"新型的vim数据库插件(暂时不用)
"Bundle 'tpope/vim-dadbod'
"tmux的状态栏
Bundle 'edkolev/tmuxline.vim'
"用于在光标移动或输入插入模式时自动清除Vim的搜索突出显示
Bundle 'pgdouyon/vim-evanesco'
"对文件的修改,删除
" Bundle 'tpope/vim-eunuch'
"轻松创建目录
" Bundle 'duggiefresh/vim-easydir'
Bundle 'npacker/vim-java-syntax-after'
Bundle 'vim/killersheep'
Bundle 'mileszs/ack.vim'
Bundle 'VundleVim/Vundle.vim'
"git包装器
Bundle 'tpope/vim-fugitive'
"模糊文件查询
Bundle 'wincent/command-t'
"Plugin 'kien/ctrlp.vim'
"函数导航器
"Bundle 'tacahiroy/ctrlp-funky'
Bundle 'Valloric/YouCompleteMe'
"右侧边栏,方便对方法的罗列和浏览
Bundle 'majutsushi/tagbar'
"自动加载脚本插件,和vim-easytags配合使用
Bundle 'xolox/vim-misc'
Bundle 'xolox/vim-easytags'
"Vim的轻量级可配置状态行/标签插件
Bundle 'itchyny/lightline.vim'
"vim-airline主题
"Bundle 'vim-airline/vim-airline'
"vim主题,比较好用的一个主题
Bundle 'morhetz/gruvbox'
"侧边文件树形导航u,可以向上切换根目录
Bundle 'scrooloose/nerdtree'
"为所有标签打开同一个导航
"Bundle 'jistr/vim-nerdtree-tabs'
" 这个插件可以显示文件的Git增删状态
Plugin 'Xuyuanp/nerdtree-git-plugin'
"语法检查工具,替代上面的
Plugin 'w0rp/ale'
"Python模式，一个用于Vim的Python IDE,注释掉报错
"Bundle 'klen/python-mode'
"文本注释插件
"  Bundle 'vim-scripts/tComment'
Bundle 'tomtom/tcomment_vim'
"可以自动关闭引号，圆括号，括号
Bundle 'jiangmiao/auto-pairs'
"js检查插件
"Bundle 'wookiehangover/jshint.vim'
"可以方便使用 Ctrl-h,ctrl-j,ctrl-k,ctrl-l 来在各个 vim 和 tmux pannel 之间跳转
Bundle 'christoomey/vim-tmux-navigator'
" Bundle 'Shougo/denite.nvim'
"应该是Java自动提示功能,一站式编写java
Bundle 'artur-shaik/vim-javacomplete2'
"平滑滚动
Bundle 'terryma/vim-smooth-scroll'
"中文vim帮助目录
Bundle 'asins/vimcdoc'
"缩进小细线
" Bundle 'yggdroot/indentline'
"异步执行shell命令在quickfix显示
" Bundle 'skywind3000/asyncrun.vim'
"主题1
" Plugin 'altercation/vim-colors-solarized'
"代码块插件
Plugin 'SirVer/ultisnips'
"代码块集合
Plugin 'honza/vim-snippets'
"数据库插件
Bundle 'vim-scripts/dbext.vim'
"编译java,运行java,自己瞎写的程序
Plugin 'chaiguolong/myTools.vim'
"========================web开发插件开始=====================
"Vim中极大地改进了Javascript缩进和语法支持
"js对齐上有bug,先用一段时间,过后删除
Bundle 'pangloss/vim-javascript'
"javascript语法高亮
Bundle 'mxw/vim-jsx'
"色彩高亮
 Bundle 'gorodinskiy/vim-coloresque'
"与YouCompleteMe结合对JavaScript补全
Bundle 'marijnh/tern_for_vim'
"缩进,
 Bundle 'lukaszb/vim-web-indent'
"HTML中ul>li*3这种快捷写法插件
Bundle 'mattn/emmet-vim'
"javascript高亮语法
Bundle 'jelera/vim-javascript-syntax'
"CSS语法高亮
Bundle 'hail2u/vim-css3-syntax'
"html5语法
Bundle 'othree/html5.vim'
"标签自动补全
Bundle 'docunext/closetag.vim'
"画流程图,结构图插件
Bundle 'liuchengxu/graphviz.vim'
"书签
Bundle 'MattesGroeger/vim-bookmarks'
"w3m浏览器插件
"Bundle 'yuratomo/w3m.vim'
"MarkDown插件
" Plugin 'godlygeek/tabular'
" Plugin 'plasticboy/vim-markdown'
" Plugin 'suan/vim-instant-markdown'

"========================web开发插件结束=====================
call vundle#end()
filetype plugin indent on
" 插件列表结束


"快捷键
"" 映射全选+复制 ctrl+a
" zz # 将当前行置于屏幕中间（不是转载…）  
" zt # 将当前行置于屏幕顶端（不是猪头~）  
" zb # 底端啦~  
" za 展开和关闭折叠,zi展开所有折叠
map <C-A> ggVGY
map! <C-A> <Esc>ggVGY
map <F12> gg=G
" 设置快捷键将选中文本块复制至系统剪贴板
vnoremap <Leader>y "+y
" 设置快捷键将系统剪贴板内容粘贴至 vim
nmap <Leader>p "+p
"调整vim的尺寸
nmap w= :resize +3<CR>
nmap w- :resize -3<CR>
nmap w, :vertical resize -3<CR>
nmap w. :vertical resize +3<CR>

"test the current methond,测试当前方法
nnoremap <Leader>jv :JavaUnitExec<CR>
"test the main method 测试主方法
" nnoremap <Leader>jm :JavaUnitTestMain<CR>
"进入文件目录,编译该文件
nnoremap <Leader>jj :MyToolsServerCompilePro<CR>
nnoremap <Leader>jmn :MyToolsServerCompileProWithMaven<CR>
"部署应用
nnoremap <Leader>jd :MyToolsServerCompilePro2<CR>
nmap <Leader>m %

"平滑滚动插件的快捷键
noremap <silent> <c-u> :call smooth_scroll#up(&scroll, 0, 2)<CR>
noremap <silent> <c-d> :call smooth_scroll#down(&scroll, 0, 2)<CR>

"切换tab页:
nmap <Leader>1 1gt
nmap <Leader>1 1gt
nmap <Leader>2 2gt
nmap <Leader>3 3gt
nmap <Leader>4 4gt
nmap <Leader>5 5gt
nmap <Leader>6 6gt
nmap <Leader>7 7gt
nmap <Leader>8 8gt
nmap <Leader>9 9gt
nmap <Leader>0 :tablast<CR>

"自动切换工作路径
"在eclipse的项目中在项目根目录vim打开,将自动切换工作目录注释掉是因为添加classpath的需要,插件javacomplete2.vim
set autochdir



"插件配置
" 随 vim 自启动
let g:indent_guides_enable_on_vim_startup=1
" 从第二层开始可视化显示缩进
let g:indent_guides_start_level=0
" 色块宽度
let g:indent_guides_guide_size=1
" 快捷键 i 开/关缩进可视化
:nmap <silent> <Leader>i <Plug>IndentGuidesToggle

" 使用 NERDTree 插件查看工程文件。设置快捷键，速记：file list
"

nnoremap <C-n> :NERDTreeToggle<CR>
" 设置NERDTree子窗口宽度
let NERDTreeWinSize=40
" 设置NERDTree子窗口位置
let NERDTreeWinPos="left"
" 显示隐藏文件
let NERDTreeShowHidden=1
" NERDTree 子窗口中不显示冗余帮助信息
let NERDTreeMinimalUI=1
" 删除文件时自动删除文件对应 buffer
let NERDTreeAutoDeleteBuffer=1
"显示行号
let NERDTreeShowLineNumbers = 1
"忽略特定文件和目录
let NERDTreeIgnore=[ '\.pyc$', '\.pyo$', '\.py\$', '\.obj$',
            \ '\.o$', '\.so$', '\.egg$', '^\.git$', '__pycache__', '\.DS_Store','\.project$','\.settings$' ]
:set modifiable

"====================================tmux=======================================

let g:tmux_navigator_no_mappings = 1

nnoremap <silent> <C-h> :TmuxNavigateLeft<cr>
nnoremap <silent> <C-j> :TmuxNavigateDown<cr>
nnoremap <silent> <C-k> :TmuxNavigateUp<cr>
nnoremap <silent> <C-l> :TmuxNavigateRight<cr>
nnoremap <silent> <C-\> :TmuxNavigatePrevious<cr>

"在从Vim导航到tmux窗格之前写入所有缓冲区
let g:tmux_navigator_save_on_switch = 2

"查单词
nmap <Leader>y :!echo --==<C-R><C-w>==-- ;ici <C-R><C-W><CR>

"====================================tmux=======================================

" YCM 补全菜单配色
" YCM 集成 OmniCppComplete 补全引擎，设置其快捷键
"inoremap <leader><Tab> <C-x><C-o>
"回车即选中项
"inoremap <expr> <CR> pumvisible() ? "\<C-y>" : "\<CR>"
" 菜单
"highlight Pmenu ctermfg=2 ctermbg=3 guifg=#005f87 guibg=#EEE8D5
" 选中项
"highlight PmenuSel ctermfg=2 ctermbg=3 guibg=#AF3400 guifg=#10946f

"20180801
"屏蔽YCM 自动弹出函数原型预览窗口
set completeopt=menu,menuone
let g:ycm_add_preview_to_completeopt = 0
"屏蔽YCM默认诊断信息
let g:ycm_show_diagnostics_ui = 1
" css补全
let g:ycm_semantic_triggers = {
   \   'css': [ 're!^\t', 're!:\s+' ],
   \ }

"-----------------20191012----------------

" 寻找全局配置文件
let g:ycm_global_ycm_extra_conf = '~/.vim/bundle/YouCompleteMe/cpp/ycm/.ycm_extra_conf.py'
" 开启语义补全
" 修改对C语言的补全快捷键，默认是CTRL+space，修改为ALT+;未测出效果
let g:ycm_key_invoke_completion = '<M-;>'
" 禁用syntastic来对python检查
let g:syntastic_ignore_files=[".*\.py$"] 
" 设置转到定义处的快捷键为ALT+G，未测出效果
"nmap <M-g> :YcmCompleter GoToDefinitionElseDeclaration <C-R>=expand("<cword>")<CR><CR> 
"关键字补全
let g:ycm_seed_identifiers_with_syntax = 1
" 在接受补全后不分裂出一个窗口显示接受的项
set completeopt-=preview
" 让补全行为与一般的IDE一致
set completeopt=longest,menu
" 不显示开启vim时检查ycm_extra_conf文件的信息
let g:ycm_confirm_extra_conf=0
" 每次重新生成匹配项，禁止缓存匹配项
let g:ycm_cache_omnifunc=0
" 在注释中也可以补全
let g:ycm_complete_in_comments=1"
"-----------------20191012----------------


"下列定义如果不卡可以放开
"========================================试验================================

" 补全功能在注释中同样有效
let g:ycm_complete_in_comments=1
"let g:ycm_complete_in_comments=1
" 允许 vim 加载 .ycm_extra_conf.py 文件，不再提示
let g:ycm_confirm_extra_conf=0
" 开启 YCM 标签补全引擎
"let g:ycm_collect_identifiers_from_tags_files=1
" 引入 C++ 标准库tags
"set tags+=/data/misc/software/misc./vim/stdcpp.tags
"set tags+=/data/misc/software/misc./vim/stdcpp.tags
" 补全内容不以分割子窗口形式出现，只显示补全列表
"set completeopt-=preview
"set completeopt-=preview
" 从第一个键入字符就开始罗列匹配项
let g:ycm_min_num_of_chars_for_completion=2
" 禁止缓存匹配项，每次都重新生成匹配项
let g:ycm_cache_omnifunc=0
" 语法关键字补全           
let g:ycm_seed_identifiers_with_syntax=1
" let g:ycm_seed_identifiers_with_syntax=0
"禁用Java语法其他诊断
"let g:syntastic_java_checkers  = []
"禁用语法检查
"let g:ycm_show_diagnostics_ui = 0
"禁用ycm的语法错误检测提
let g:ycm_enable_diagnostic_signs = 0
let g:ycm_enable_diagnostic_highlighting = 0

"打开chrome
nnoremap <Leader>o :exec '!exec open %'<CR>

" map the function key to preview the dot file
" autocmd BufRead *.dot 
nmap <F8> :w<CR>:!dot -Tpng -o %<.png % && open /Applications/Preview.app %<.png<CR><CR>

"==============================================vim-javacomplete2=======================================================START
"将其添加到您的.vimrc文件中：
"
autocmd FileType java setlocal omnifunc=javacomplete#Complete
autocmd FileType css setlocal omnifunc=csscomplete#CompleteCSS
" autocmd FileType html setlocal omnifunc=htmlcomplete#CompleteTags
" #注释掉用tern_for_vim
" autocmd FileType javascript setlocal omnifunc=javascriptcomplete#CompleteJS
autocmd FileType sql setlocal omnifunc=sqlcomplete#Complete
autocmd FileType xml setlocal omnifunc=xmlcomplete#CompleteTags
"othree/html5.vim的方法
autocmd FileType html set omnifunc=htmlcomplete#DetectOmniFlavor
"graphviz
" " autocmd FileType dot set omnifunc=graphviz#completion#Omni

" 默认编译生成 pdf 格式，如果想要其他格式，将 pdf 换成其他格式即可
let g:graphviz_output_format = 'png'
" 构造javacomplete2使用python3解释器而不是python2:
" let g:JavaComplete_UsePython3 = 1
let g:JavaComplete_ShowExternalCommandsOutput=1
"导入默认导入第一项,设置-1为禁止
let g:JavaComplete_ImportDefault = -1


"tagbar{{{
    "按F9即可打开tagbar界面
    nmap <c-t> :TagbarToggle<CR>
    "tagbar以来ctags插件
    let g:tagbar_ctags_bin = 'ctags'                
    "让tagbar在页面左侧显示，默认右边
    let g:tagbar_left = 0
    "设置tagbar的宽度为30列，默认40
    let g:tagbar_width = 30                         
    "这是tagbar一打开，光标即在tagbar页面内，默认在vim打开的文件内
    let g:tagbar_autofocus = 1                      
    "设置标签排序,默认排序
    let g:tagbar_sort = 0                           
    "let g:tagbar_left = 0

    "设置tags选项为当前目录下的tags文件
    set tags=tags   
"}}}

"UltiSnips{{{
    "插入模式下直接通过<C-z>键来触发UltiSnips的代码块补全
    let g:UltiSnipsExpandTrigger="<C-l>"
	"<C-f>跳转的到下一个代码块可编辑区
	let g:UltiSnipsJumpForwardTrigger="<C-f>"
	"<C-b>跳转到上一个代码块可编辑区
	let g:UltiSnipsJumpBackwardTrigger="<C-b>"
"}}}

"============================数据库插件配置===============================
let g:dbext_default_profile_mySQL_web08 = 'type=MYSQL:user=root:passwd=mysql:dbname=web08'
let g:dbext_default_profile_mySQL_heimashop = 'type=MYSQL:user=root:passwd=mysql:dbname=heimashop'
let g:dbext_default_profile_mySQL_hibernate = 'type=MYSQL:user=root:passwd=mysql:dbname=hibernate'
let g:dbext_default_profile_mySQL_springmvc= 'type=MYSQL:user=root:passwd=mysql:dbname=springmvc'
let g:dbext_default_profile_mySQL_crm= 'type=MYSQL:user=root:passwd=mysql:dbname=crm'
let g:dbext_default_profile_mySQL_mybatis= 'type=MYSQL:user=root:passwd=mysql:dbname=mybatis'
let g:dbext_default_profile_mySQL_mydb1 = 'type=MYSQL:user=root:passwd=mysql:dbname=mydb1'
let g:dbext_default_profile_mySQL_day05 = 'type=MYSQL:user=root:passwd=mysql:dbname=day05'
let g:dbext_default_profile_mySQL_whiteDream = 'type=MYSQL:user=root:passwd=mysql:dbname=whiteDream'
let g:dbext_default_profile_ORA_URL = 'type=ORA:srvname=//192.168.31.200\:1521/orcl:user=scott:passwd=tiger'
let g:dbext_default_profile_ORA_Extended = 'type=ORA:user=scott:passwd=tiger:srvname=(description=(address=(protocol=TCP)(host=192.168.31.200)(port=1521))(connect_data=(server=dedicated)(service_name=orcl)))'

"连接数据库\sbp is derived from s (SQL) b (buffer) p (prompt)
"nnoremap <Leader>sql <Leader>sbp
"<Leader>sel - s (sql) e (execute) l (line)


"========================pangloss/vim-javascript配置====================
"控制某些语法突出显示插件
let g:javascript_plugin_jsdoc = 1


nnoremap <leader>h  :call HeightToSize(5)<cr>
nnoremap <leader>h1 :call HeightToSize(10)<cr>
nnoremap <leader>h2 :call HeightToSize(20)<cr>
nnoremap <leader>h3 :call HeightToSize(30)<cr>
nnoremap <leader>h4 :call HeightToSize(40)<cr>
nnoremap <leader>mm :call WidthToSize(1)<cr>
nnoremap <leader>ss :call WidthToSize(140)<cr>

"ale
""始终开启标志列
"let g:ale_sign_column_always = 1
let g:ale_set_highlights = 0
"自定义error和warning图标
let g:ale_sign_error = '✗'
let g:ale_sign_warning = '⚠'
"在vim自带的状态栏中整合ale
"let g:ale_statusline_format = ['✗ %d', '⚡%d', '✔ OK']
let g:ale_statusline_format = ['✗ %d', '⚠ %d', '✔ OK']
"显示Linter名称,出错或警告等相关信息
let g:ale_echo_msg_error_str = 'E'
let g:ale_echo_msg_warning_str = 'W'
let g:ale_echo_msg_format = '[%linter%] %s [%severity%]'
"普通模式下，sp前往上一个错误或警告，sn前往下一个错误或警告
nmap sp <Plug>(ale_previous_wrap)
nmap sn <Plug>(ale_next_wrap)
"<Leader>d查看错误或警告的详细信息
nmap <Leader>d :ALEDetail<CR>
"文件内容发生变化时不进行检查
let g:ale_lint_on_text_changed = 'never'
"打开文件时不进行检查
let g:ale_lint_on_enter = 0
"解决错误和警告乱码
"let g:ale_java_javac_options = '-encoding UTF-8  -J-Duser.language=en'

"tagbar自动关闭窗口
let g:tagbar_autoclose = 1
"打开vim时如果没有文件自动打开NERDTree
" autocmd vimenter * if !argc()|NERDTree|endif
"当NERDTree为剩下的唯一窗口时自动关闭
autocmd bufenter * if (winnr("$") == 1 && exists("b:NERDTree") && b:NERDTree.isTabTree()) | q | endif
"打开文件时自动关闭文件树
let NERDTreeQuitOnOpen=1
nnoremap <leader>ez :vsplit ~/.zshrc<cr>
let g:CommandTMatchWindowReverse=0
let g:CommandTSCMDirectories='.project,.git,.hg,.svn,.bzr,_darcs'
set wildignore+=*.o,*.obj,*.class,*.png,*.jpg
"状态行插件集成git标志,与fugitive集成
let g:lightline = {
			\'colorscheme': 'gruvbox',
			\ 'active': {
			\   'left': [ [ 'mode', 'paste' ],
			\             [ 'gitbranch', 'readonly', 'filename', 'modified' ] ]
			\ },
			\ 'component_function': {
			\   'gitbranch': 'fugitive#head'
			\ },
			\ }

"设置tmux的状态栏的分割符为0
let g:tmuxline_powerline_separators = 0
"let g:tmuxline_preset = 'nightly_fox'
"let g:tmuxline_theme = "powerline"
"let g:tmuxline_theme = "lightline_insert"
let g:tmuxline_preset = {
      \'a'    : '#S',
      \'b'    : '#W',
      \'c'    : '#H',
      \'win'  : '#I #W',
      \'cwin' : '#I #W',
      \'x'    : '%a',
      \'y'    : '#W %R',
      \'z'    : '#H'}
"对tmuxline的主题进行微调
let g:tmuxline_theme = {
    \   'a'    : [ 236, 246 ],
    \   'b'    : [ 246, 239 ],
    \   'c'    : [ 246, 236 ],
    \   'x'    : [ 246, 236 ],
    \   'y'    : [ 246, 239 ],
    \   'z'    : [ 236, 246 ],
    \   'win'  : [ 103, 236, 'bold'],
    \   'cwin' : [ 236, 246, 'bold'],
    \   'bg'   : [ 244, 236 ],
    \ }
" let g:neoterm_size=''
" let g:neoterm_fixedsize=1
"定义终端复用窗口出现的位置
let g:neoterm_default_mod="belowright"
"自动跳转到shell界面
let neoterm_autojump=1
"控制dbext插件result的高度
let dbext_default_buffer_lines = 10
let display_cmd_line = 1
let g:easytags_file = '~/.vim/tags'
"easytags异步更新
" let g:easytags_async = 1
" let g:JavaComplete_JavaviLogLevel = 'debug'
" let g:JavaComplete_JavaviLogDirectory = '/Users/mymac/Loglet
let g:JavaUnit_custom_tempdir = "/Users/mymac/Documents/JavaWeb01/crm32/build/classes/"
"let g:JavaComplete_LibsPath ="/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/aopalliance-1.0.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/asm-3.3.1.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/aspectjweaver-1.8.4.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/cglib-2.2.2.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/commons-codec-1.6.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/commons-collections-1.0.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/commons-fileupload-1.2.2.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/commons-io-1.3.2.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/commons-lang3-3.1.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/commons-lang3-3.4.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/commons-logging-1.2.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/commons-pool2-2.0.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/dom4j-1.6.1.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/druid-1.0.9.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/hamcrest-core-1.3.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/jackson-annotations-2.4.0.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/jackson-core-2.4.2.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/jackson-databind-2.4.2.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/json-20131018.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/jsp-api.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/jstl-1.2.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/junit-4.12.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/log4j-1.2.17.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/mybatis-3.2.7.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/mybatis-spring-1.2.2.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/mysql-connector-java-5.1.8.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/servlet-api.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/slf4j-api-1.6.6.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/slf4j-log4j12-1.6.6.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-aop-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-aspects-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-beans-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-context-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-context-support-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-core-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-expression-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-jdbc-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-jms-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-messaging-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-test-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-tx-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-web-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/spring-webmvc-4.1.3.RELEASE.jar:/Users/mymac/Documents/JavaWeb01/crm32/WebContent/WEB-INF/lib/standard-1.1.2.jar:."
